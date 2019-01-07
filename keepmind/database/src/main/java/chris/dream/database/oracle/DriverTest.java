package chris.dream.database.oracle;

/**
 * @author Chris
 * @description: <p>...</p>
 * @date 下午 2:43 2018-12-19
 */
public class DriverTest {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
