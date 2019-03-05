package chris.dream.bonc.iot;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.sql.*;
import java.util.List;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 2019-02-28
 */
public class QueryDemo {
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/cloudiip_iot?characterEncoding=utf-8&autoReconnect=true";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) {
        String sql = "select id, iot_property from data_point";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String iotPro = resultSet.getString(2);
                System.out.println(id + "  " + iotPro);
            }
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
