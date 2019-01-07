package chris.dream.jvm.classloader.hotswap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 4:10 2018-12-13
 */
public class MainTest {

    public static void main(String[] args) {
        InputStream is = null;
        byte[] b = new byte[0];
        try {
            is = new FileInputStream("C:/Users/lkai1/Desktop/TestClass.class");
            b = new byte[is.available()];
            is.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(JavaClassExecuter.execute(b));
    }
}
