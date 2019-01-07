package chris.dream.io.input;

import java.io.*;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 2:43 2018-12-26
 */
public class InputStreamTest {

    public static void main(String[] args) throws IOException {
//        testByteArrayInputStream();
        testDataInputStream();
    }


    public static void testByteArrayInputStream() throws IOException {
        String str = "Hello world!";
        InputStream byteArrayInputStream = null;
        try {
            // 获取byte[]
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            // 缓冲区大小
            int length = 1024;
            // 创建缓冲byte数组
            byte[] buffer = new byte[length];
            // 将输入流的指定区间的内容读入到缓冲区
            byteArrayInputStream.read(buffer, 0, length);
            // 获取缓冲区内容，转为字符串输出
            System.out.println(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != byteArrayInputStream){
                byteArrayInputStream.close();
            }
        }
    }

    public static void testDataInputStream() {
        InputStream inputStream = new ByteArrayInputStream("Hello".getBytes());
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            Character c = dataInputStream.readChar();
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
