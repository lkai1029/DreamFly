package chris.dream.other.hexun;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Chris
 * @description: <p>北京银行提取和讯数据</p>
 * 和讯、中国人民银行、银监会
 * @date 下午 5:17 2018-09-11
 */
@Slf4j
public class HXAnalysis {

    private final static String[] indexes = {"news-201708", "news-201709", "news-201710", "news-201711", "news-201712",
            "news-201801", "news-201802", "news-201803", "news-201804", "news-201805", "news-201806", "news-201807", "news-201808",
            "news-201809"};

    private final static int PER_SIZE = 1000;

    private final static String OUT = "E:\\BONC\\Document\\和讯网";

    public static void main(String[] args) {

        int totalSize = 0;

        for(String index : indexes){

            int size = countIndex(index);
            totalSize += size;
            System.out.println(index + ":" + size);
            if(size <= 0) {
                log.error(index + "内容为空");
                continue;
            }

            for(int i = 0; i < size + PER_SIZE; i += PER_SIZE){
                readES2Json(index, i, i + PER_SIZE);
            }
        }

        System.out.println("Total : " + totalSize);
    }

    public static int countIndex(String index){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ESManager.getConnection(index);
            String sql = "select count(_id) from documents " +
                    "where site_name = '和讯网' or site_name = '中国银行业监督管理委员会' or site_name = '中国人民银行'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ESManager.close(conn, ps, rs);
        }

        return -1;
    }

    public static void readES2Json(String index, int start, int end){
        String fileName = OUT + File.separator + index + "_" + start + "_" + end + ".json";
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        StringBuilder content = new StringBuilder();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ESManager.getConnection(index);
            String sql = "select 'ukey', 'startid', 'url', 'title', 'site_name', 'board_name', " +
                    "'group_name', 'channel_type', 'media_type', " +
                    "'url_suffix', 'fetch_time', 'publish_time', 'charset', " +
                    "'article_from', 'author', 'author_id', 'content', " +
                    "'plain_text', 'urlbody', 'text_length', 'table_count', " +
                    "'image_count', 'forum_order', 'category', 'sim_ukey', " +
                    "'sim_degree', 'doc_image', 'doc_table'  from documents " +
                    "where site_name = '和讯网' or site_name = '中国银行业监督管理委员会' or site_name = '中国人民银行' " +
                    "limit " + start + "," + PER_SIZE;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String json = null;
                try {
                    json = JSON.toJSONString(new News(rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7),
                            rs.getString(8), rs.getString(9),
                            rs.getString(10), rs.getString(11),
                            rs.getString(12), rs.getString(13),
                            rs.getString(14), rs.getString(15),
                            rs.getString(16), rs.getString(17),
                            rs.getString(18), rs.getString(19),
                            rs.getString(20), rs.getString(21),
                            rs.getString(22), rs.getString(23),
                            rs.getString(24), rs.getString(25),
                            rs.getString(26), rs.getString(27),
                            rs.getString(28)));
                    content.append(json).append("\r\n");
                } catch (SQLException e) {
                    log.warn("读取错误");
                    continue;
                }
            }
        } catch (SQLException e) {
            log.error("SQL 异常。", e);
        } finally {
            ESManager.close(conn, ps, rs);
        }

        try (OutputStream out = new FileOutputStream(file);
                OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8")) {
            writer.write(content.toString());
        } catch (FileNotFoundException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }


    }
}
