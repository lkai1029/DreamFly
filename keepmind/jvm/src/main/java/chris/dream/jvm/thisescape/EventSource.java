package chris.dream.jvm.thisescape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 12:13 2018-12-18
 */
public class EventSource<T> {
    private final List<T> eventListeners ;
    public EventSource() {
        eventListeners = new ArrayList<T>() ;
    }

    public synchronized void registerListener(T eventListener) {  //数组持有传入对象的引用
        this.eventListeners.add(eventListener);
        this.notifyAll();
    }

    public synchronized List<T> retrieveListeners() throws InterruptedException {  //获取持有对象引用的数组
        List<T> dest = null;
        if(eventListeners.size() <= 0 ) {
            this.wait();
        }
        dest = new ArrayList<T>(eventListeners.size());  //这里为什么要创建新数组，好处在哪里
        dest.addAll(eventListeners);
        return dest;
    }
}
