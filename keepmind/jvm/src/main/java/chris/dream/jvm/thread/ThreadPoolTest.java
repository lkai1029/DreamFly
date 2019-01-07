package chris.dream.jvm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 4:33 2018-12-20
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            exec.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String threadName = Thread.currentThread().getId() + " " + Thread.currentThread().getName();
                System.out.println(threadName);
            });
        }

        while(!exec.isShutdown()){
            int active = ((ThreadPoolExecutor)exec).getActiveCount();
            System.out.println(((ThreadPoolExecutor)exec).getActiveCount());
            if(0 == active){
                break;
            }
            Thread.sleep(100);
        }
        System.out.println("End");

        exec.shutdownNow();
    }


}
