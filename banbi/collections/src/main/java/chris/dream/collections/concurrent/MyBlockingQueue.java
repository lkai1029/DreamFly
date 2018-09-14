package chris.dream.collections.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 8:28 2018-08-19
 */
public class MyBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();
        System.out.println(queue);
    }
}
