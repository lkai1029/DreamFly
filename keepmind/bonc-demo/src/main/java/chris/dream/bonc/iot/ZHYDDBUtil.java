package chris.dream.bonc.iot;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 4:59 2019-01-16
 */
public class ZHYDDBUtil {
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/cloudiip_iot?characterEncoding=utf-8&autoReconnect=true";
    private static String username = "root";
    private static String password = "root";

    private static String dirName = "E:\\Document\\BONC-工业互联网\\智慧用电\\模板-template";

    public static void main(String[] args) {
        File dir = new File(dirName);
        String[] filenames = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.contains("EM721")){
                    return true;
                }
                return false;
            }
        });

        List<String[]> datas = new ArrayList<>();
        for(String filename : filenames) {
            filename = dirName + File.separator + filename;
            System.out.println(filename);
            datas.addAll(readDatas(filename));
        }
        System.out.println(datas.size());
        System.out.println(JSON.toJSONString(datas));

        insertData(datas);
    }

    private static List<String[]> readDatas(String filename) {
        List<String[]> datas = new ArrayList<>();

        // 1M
        int buffSize = 1024 *1024;
        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            // 下一行是data_point_type
            boolean nextIsType = false;
            int lineNum = 0;
            String templateName = null;
            String dataPointType = null;

            String line = null;
            while(null != (line = bufferedReader.readLine())) {
                System.out.println(line);
                if(lineNum == 0) { // 第一行为模板名
                    templateName = line.trim();
                } else if(StringUtils.isEmpty(line.trim())) { // 如果当前行内容为空，则下一行是数据点类型
                    nextIsType = true;
                } else if(nextIsType){ // 如果当前行是数据点类型，则取值作为数据点类型
                    dataPointType = line.trim();
                    nextIsType = false;
                } else {
                    String[] tmpData = line.split("\\s{1,}");
                    int len = tmpData.length;
                    System.out.println(len);
                    if(len > 4) { // 如果长度大于4，合并4之后的内容作为4
                        StringBuilder p4 = new StringBuilder();
                        for(int i = 3; i < tmpData.length; i++) {
                            if(i == len - 1) {
                                p4.append(tmpData[i]);
                            } else {
                                p4.append(tmpData[i]).append(" ");
                            }
                        }
                        tmpData[3] = p4.toString();
                    }

                    String[] data = new String[6];
                    data[0] = templateName;
                    data[1] = dataPointType;
                    System.arraycopy(tmpData, 0, data, 2, 4);

                    datas.add(data);
                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;
    }

    /**
     * @param datas 0:temolateName, 1:data_point_type, 2:iot_pro_name, 3:iot_property, 4:data_type, 5:note
     */
    private static void insertData(List<String[]> datas) {
        String sql = "insert into `template` (id, template_name, iot_type, iot_pro_name, iot_property, data_type, note) " +
                "values (uuid(), ?, ? ,? ,? ,? ,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            for(String[] data : datas){
                preparedStatement.setString(1, data[0]);
                preparedStatement.setString(2, data[1]);
                preparedStatement.setString(3, data[2]);
                preparedStatement.setString(4, data[3]);
                preparedStatement.setString(5, data[4]);
                preparedStatement.setString(6, data[5]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
