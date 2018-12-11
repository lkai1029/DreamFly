package chris.dream.javabasics.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * JDBC工具类
 * @ClassName: DBUtil
 * @Package com.bonc.poc.plugin.util
 * @author Chris E-mail:likai@bonc.com.cn
 * @date 2016年12月26日 下午3:19:52
 */
public class DBUtil {
	
	private DBUtil(){
		
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
	public static void close(Connection conn, PreparedStatement ps){
		close(conn, ps, null);
    }
	
	public static void close(Connection conn){
		close(conn, null);
    }
	
	public static void close(PreparedStatement ps, ResultSet rs){
		close(null, ps, rs);
	}
	
	public static void close(PreparedStatement ps){
		close(null, ps, null);
	}
	
}
