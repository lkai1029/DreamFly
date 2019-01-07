package chris.dream.jvm.thisescape;

import java.util.EventListener;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 12:13 2018-12-18
 */
public class ThisEscape {
    public final int id;
    public final String name;
    public ThisEscape(EventSource<EventListener> source) {
        id = 1;
        source.registerListener(new EventListener() {  //内部类是可以直接访问外部类的成员变量的（外部类引用this被内部类获取了）
            public void onEvent(Object obj) {
                System.out.println("id: "+ThisEscape.this.id);
                System.out.println("name: "+ThisEscape.this.name);
            }
        });
        name = "flysqrlboy";
    } }
