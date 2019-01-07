package chris.dream.database.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPool {

	private static DBConnectionPool instance;
	
	private DataSource dataSource;
	
	private DBConnectionPool() {
		try {
			dataSource = DruidDataSourceFactory.createDataSource(DBConfig.dataBaseProp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized static DBConnectionPool getInstance() {
		if(null == instance) {
			instance = new DBConnectionPool();
		}
		return instance;
	}
	
	public Connection getConnection() {
		if(null == dataSource) {
			return null;
		}
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
