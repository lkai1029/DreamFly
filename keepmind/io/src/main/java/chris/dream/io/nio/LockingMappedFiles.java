package chris.dream.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:58 2018-12-27
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8FFFFF; // 128M
    static FileChannel fileChannel;
    static String filename = "nio_LockingMappedFiles.txt";

    public static void main(String[] args) throws Exception {
        fileChannel = new RandomAccessFile(filename, "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(
                FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
        new LockedAndModify(mappedByteBuffer, 0, LENGTH / 3);
        new LockedAndModify(mappedByteBuffer, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
    }

    private static class LockedAndModify extends Thread {
        private ByteBuffer byteBuffer;
        private int start, end;

        LockedAndModify(ByteBuffer byteBuffer, int start, int end) {
            this.start = start;
            this.end = end;
            byteBuffer.limit(end);
            byteBuffer.position(start);
            this.byteBuffer = byteBuffer.slice();
            start();
        }

        @Override
        public void run() {
            try {
                FileLock fileLock = fileChannel.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (byteBuffer.position() < byteBuffer.limit() - 1) {
                    byteBuffer.put((byte) (byteBuffer.get() + 1));
                }
                    fileLock.release();
                System.out.println("Released: " + start + " to " + end);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
