package chris.dream.io.input;

import java.io.*;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 3:29 2018-12-26
 */
public class ReaderTest {
    public static void main(String[] args) {
        testBufferedReader();
    }

    public static void testFileReader() {
        try (Reader fileReader = new FileReader("")) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void testBufferedReader() {
        String fileName = "C:\\Users\\lkai1\\Desktop\\安装指南.txt";
        int bufferLen = 10240;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName), bufferLen)) {
            String line = null;
            while(null != (line = bufferedReader.readLine())){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
