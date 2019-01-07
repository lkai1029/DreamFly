package chris.dream.io;

import java.io.File;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 12:14 2018-12-26
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\lkai1\\Desktop\\SpringAOP架构图-1.png");
        file.renameTo(new File("C:\\Users\\lkai1\\Desktop\\SpringAOP架构图.png"));

    }
}
