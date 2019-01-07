package chris.dream.jvm.threadlocal;

import java.util.Date;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:38 2018-12-20
 */
public class DateFormatRunnable implements Runnable {

    @Override
    public void run() {
        Date now = new Date();
        String threadName = Thread.currentThread().getId() + " " + Thread.currentThread().getName();
        System.out.println(threadName + "   " + Constant.FORMAT_THREAD_LOCAL.get().format(now));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
