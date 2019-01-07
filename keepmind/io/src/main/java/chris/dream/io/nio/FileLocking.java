package chris.dream.io.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:05 2018-12-27
 */
public class FileLocking {
    static String filename = "nio_FileLocking.txt";

    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            /**
             * 尝试获取锁
             */
            FileLock lock = fileOutputStream.getChannel().tryLock();
            if(null != lock){
                System.out.println("Locked file");
                TimeUnit.SECONDS.sleep(10);
                lock.release(); // 释放锁
                System.out.println("Released lock");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
