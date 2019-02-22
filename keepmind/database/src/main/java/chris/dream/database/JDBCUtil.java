package chris.dream.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 上午 10:24 2019-01-10
 */
public class JDBCUtil {
    private static final String className = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/jdbc_demo";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(getConnection().getClass().getName());
    }
}
