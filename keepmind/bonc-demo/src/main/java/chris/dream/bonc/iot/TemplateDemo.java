package chris.dream.bonc.iot;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 2:32 2019-01-24
 */
public class TemplateDemo {
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/cloudiip_iot_demo?characterEncoding=utf-8&autoReconnect=true";
    private static String username = "root";
    private static String password = "root";

    private static String dirName = "E:\\Document\\BONC-工业互联网\\智慧用电\\模板-template";

    private static String templateName = "EM721FA-E";
    private static String iotType = "事件";

    public static void main(String[] args) {
        String filename = dirName + File.separator + "EM721FA-E-事件.txt";

        List<String[]> datas = readDatas(filename);
        System.out.println(datas.size());
        System.out.println(JSON.toJSONString(datas));

        insertData(datas);
    }

    private static List<String[]> readDatas(String filename) {
        List<String[]> datas = new ArrayList<>();

        try(FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = null;
            while(null != (line = bufferedReader.readLine())) {
                String[] data = line.split("\\s{1,}");
                datas.add(data);
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
        String sql = "insert into `template` values (uuid(),0,null,0,0,null,0,?,?,?,?,0, \"int16u\", ?, 0);";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            for(String[] data : datas){
                preparedStatement.setString(1, templateName);
                preparedStatement.setString(2, iotType);
                preparedStatement.setString(3, data[0]);
                preparedStatement.setString(4, data[1]);
                preparedStatement.setString(5, data[1]);
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
