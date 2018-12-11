package chris.dream.xml.emr;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;

/**
 * @author Chris
 *
 * @description: <p>医疗数据解析</p>
 * @date 下午 12:04 2018-09-05
 */
@Slf4j
class EmrReader {

    public static void main(String[] args) {
        String inPath = "E:\\BONC\\NLAP-文本分析系统\\Document\\EMR数据\\tmp";
        String outPath = "E:\\BONC\\NLAP-文本分析系统\\Document\\EMR数据\\tmp-out-2";
        getEmrContent(inPath, outPath);
    }

    public static void getEmrContent(String inPath, String outPath){
        File inDir = new File(inPath);
        if(!inDir.isDirectory()){
            return;
        }

        File outDir = new File(outPath);
        if(!outDir.exists() || !outDir.isDirectory()){
            outDir.mkdirs();
        }

        String[] files = inDir.list();
        for(String filename : files){
            String inFilePath = inPath + File.separator + filename;
            String originalContent = readContent(inFilePath);

            int contentStart = originalContent.indexOf("<内容>");
            int contentEnd = originalContent.indexOf("</内容>");

            String content = originalContent.substring(contentStart + 4, contentEnd - 1)
                    .replaceAll("&#13;", "").replaceAll("--&gt", "")
                    .replaceAll("&#13", "");
//            System.out.println(content);
//            try {
//                content = EntityFilter.filterEntity(content);
//            } catch (Exception e) {
//                log.error("", e);
//            }
//            System.out.println(content);

            String outFilePath = outPath + File.separator + filename.replace(".xml", ".txt");
            writeContent(outFilePath, content);
        }
    }

    /**
     * 通过xml方式读取emr数据（数据存在特殊字符，不能直接得到结果）
     * @param xmlPath
     * @return
     */
    public static String readEmrContent(String xmlPath){
        SAXReader reader = new SAXReader();
        String content = null;
        try {
            Document document = reader.read(new File(xmlPath));
            Element rootElement = document.getRootElement();
            content = rootElement.elementText("内容");
        } catch (DocumentException e) {
           log.error("", e);
        }
        return content;
    }

    public static String readContent(String inPath){
        StringBuilder content = new StringBuilder();
        try(InputStream in = new FileInputStream(inPath);
            InputStreamReader inReader = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(inReader)) {
            String line = null;
            while(null != (line = reader.readLine())){
                content.append(line).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }
        return content.toString();
    }

    private static void writeContent(String outPath, String content){
        try (OutputStream out = new FileOutputStream(outPath);
                OutputStreamWriter writer = new OutputStreamWriter(out)) {
            writer.write(content);
        } catch (FileNotFoundException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }
    }

}
