package chris.dream.io.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:38 2018-12-27
 */
public class LargeMappedFiels {
    static int length = 0X8F;
    static String fileName = "nio_LargeMappedFiels.txt";

    public static void main(String[] args) throws Exception {
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile(fileName, "rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++){
            mappedByteBuffer.put((byte) 'x');
        }
        System.out.println("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) mappedByteBuffer.get(i));
        }
    }
}
