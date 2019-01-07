package chris.dream.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 5:39 2018-12-26
 */
public class BufferToText {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filename = "nio_BufferToText.txt";

        FileChannel fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new FileInputStream(filename).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip(); // 让buff处于准备被读状态
        // 乱码
        System.out.println(buff.asCharBuffer());

        buff.rewind(); // 重置position
        // Decode using this system's default Charset:
        String encoding = System.getProperty("file.encoding");
        // 将buff解码读取-->这一步将buff的编码转换成了系统编码
        System.out.println("Decoded using " + encoding + " : " +
                Charset.forName(encoding).decode(buff));

        // Or, we could encode with something that will print:
        fc = new FileOutputStream(filename).getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        // Now try reading again:
        fc = new FileInputStream(filename).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        // Use a CharBuffer to write through:
        fc = new FileOutputStream(filename).getChannel();
        buff = ByteBuffer.allocate(24);
        // 将ByteBuffer转换成CharBuffer，使用put写入
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();

        // Read and display:
        fc = new FileInputStream(filename).getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());


    }

}
