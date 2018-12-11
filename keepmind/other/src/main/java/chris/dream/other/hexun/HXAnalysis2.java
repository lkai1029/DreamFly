package chris.dream.other.hexun;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 6:17 2018-09-12
 */
@Slf4j
public class HXAnalysis2 {


    private final static int PER_SIZE = 1000;

    private final static String OUT = "E:\\BONC\\Document\\和讯网";

    public static void main(String[] args) {

        int totalSize = 0;

        String index  = "news-201802";
        int size = HXAnalysis.countIndex(index);
        totalSize += size;
        System.out.println(index + ":" + size);
        if (size <= 0) {
            log.error(index + "内容为空");
            return;
        }

        HXAnalysis.readES2Json(index, 99000, 100000);

        System.out.println("Total : " + totalSize);
    }
}
