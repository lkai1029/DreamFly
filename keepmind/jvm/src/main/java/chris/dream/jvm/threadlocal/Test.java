package chris.dream.jvm.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:54 2018-12-20
 */
public class Test {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        List<Thread> ts = new ArrayList<>(100);
        /**
         * 如果想要多线程并发执行，不要在start之后join：
         *  如果start之后join，会在进入下一次循环之前，等待此次线程执行完毕，才会开启下一个线程
         */
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(new DateFormatRunnable());
            ts.add(t);
            t.start();
        }
        for(Thread t : ts){
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
