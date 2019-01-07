package chris.dream.jvm.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 9:29 2018-12-25
 */
public class ReentrantLockTest {
    static String str = "Hello world!";

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("Thread A " + str);
            }).start();
        }
        lock.unlock();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("Thread B " + str);
            }).start();
        }
    }
}
