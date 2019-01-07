package chris.dream.bonc.magicube;

import chris.dream.bonc.util.PDFReader;
import com.bonc.text.sdk.client.TextAbsKeywordClient;
import com.bonc.text.sdk.client.TextEntityIdentifyClient;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:15 2019-01-07
 */
public class TestA {

    private static String pdfDirPath = "C:\\Users\\lkai1\\Desktop\\Chris\\" +
            "国家能源集团工程公司大数据项目POC测试文件\\投标文件";

    private static String nlpDomain = "172.16.3.116:9187";

    private static TextAbsKeywordClient textAbsKeywordClient =
            TextAbsKeywordClient.getInstance(nlpDomain);

    private static TextEntityIdentifyClient textEntityIdentifyClient =
            TextEntityIdentifyClient.getInstance(nlpDomain);

    private static String outPath = pdfDirPath + "\\nlpOut.txt";

    public static void main(String[] args) throws IOException {
        String[] pdfPaths = new File(pdfDirPath).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".pdf");
            }
        });

        StringBuilder result = new StringBuilder();

        if (null != pdfPaths) {
            System.out.println("total files : " + pdfPaths.length);
            for (String pdfPath : pdfPaths) {
                System.out.println("File is : " + pdfPath);
                String filename = pdfDirPath + File.separator + pdfPath;
                String content = PDFReader.getPdfFileText(filename);

                System.out.println("File length : " + content.length());

                String keywordsJSON = textAbsKeywordClient.getKeywords("", content, 20);
                result.append(pdfPath).append("\r\n").append(keywordsJSON).append("\r\n");
                String entityJson = textEntityIdentifyClient.extractBasicEntitiesMultiModel(
                        null, content, true, true);
                result.append(entityJson).append("\r\n\r\n");
            }
        }

        writeResult(result.toString(), outPath);
    }

    private static void writeResult(String content, String filepath) {
        int buffLength = 1024 * 1024;
        try (FileOutputStream fileOutputStream = new FileOutputStream(filepath);
             FileChannel fileChannel = fileOutputStream.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(buffLength);
            byteBuffer.put(content.getBytes());
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
