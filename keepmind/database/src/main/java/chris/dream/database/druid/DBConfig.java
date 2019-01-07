package chris.dream.database.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBConfig {

	private final static String PROPERTIES_FILE_NAME = "application.properties";

	private final static String DB_DRIVER_PROP = "datasource.driverClassName";
	private final static String DB_URL_PROP = "datasource.url";
	private final static String DB_USERNAME_PROP = "datasource.username";
	private final static String DB_PASSWORD_PROP = "datasource.password";
	private final static String DB_INITIAL_SIZE_PROP = "datasource.initialSize";
	private final static String DB_MAXACTIVE_PROP = "datasource.maxActive";
	private final static String DB_MINIDLE_PROP = "datasource.minIdle";
	private final static String DB_MAXWAIT_PROP = "datasource.maxWait";

	/**
	 * datasource 配置
	 */
	protected static Map<String, String> dataBaseProp = new HashMap<>();
	
	private static String DB_DRIVER;
	private static String DB_URL;
	private static String DB_USERNAME;
	private static String DB_PASSWORD;
	private static String DB_INITIAL_SIZE; // 初始化时建立物理连接的个数。
	private static String DB_MAXACTIVE; // 最大连接池数量
	private static String DB_MINIDLE; // 最小连接池数量
	private static String DB_MAXWAIT; // 获取连接时最大等待时间，单位毫秒。

	static {
		Properties prop = new Properties();
		try (InputStream in = DBConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)){
			prop.load(in);
			
			String tmpDriver = prop.getProperty(DB_DRIVER_PROP, "com.mysql.jdbc.Driver");
			DB_DRIVER = StringUtils.isNotEmpty(tmpDriver) ? tmpDriver : "com.mysql.jdbc.Driver";
			
			String tmpUrl = prop.getProperty(DB_URL_PROP, 
					"jdbc:mysql://127.0.0.1:3306/text?useUnicode=true&characterEncoding=utf8");
			DB_URL = StringUtils.isNotEmpty(tmpUrl) ?
					tmpUrl : "jdbc:mysql://127.0.0.1:3306/text?useUnicode=true&characterEncoding=utf8";
			
			String tmpUsername = prop.getProperty(DB_USERNAME_PROP, "root");
			DB_USERNAME = StringUtils.isNotEmpty(tmpUsername) ? tmpUsername : "root";
			
			String tmpPassword = prop.getProperty(DB_PASSWORD_PROP, "root");
			DB_PASSWORD = StringUtils.isNotEmpty(tmpPassword) ? tmpPassword : "root";
			
			String tmpInitialSize = prop.getProperty(DB_INITIAL_SIZE_PROP, "3");
			DB_INITIAL_SIZE = StringUtils.isNotEmpty(tmpInitialSize) ? tmpInitialSize : "3";
			
			String tmpMaxActive = prop.getProperty(DB_MAXACTIVE_PROP, "10");
			DB_MAXACTIVE = StringUtils.isNotEmpty(tmpMaxActive) ? tmpMaxActive : "10";
			
			String tmpMinIdle = prop.getProperty(DB_MINIDLE_PROP, "0");
			DB_MINIDLE = StringUtils.isNotEmpty(tmpMinIdle) ? tmpMinIdle : "0";
			
			String tmpMaxWait = prop.getProperty(DB_MAXWAIT_PROP, "60000");
			DB_MAXWAIT = StringUtils.isNotEmpty(tmpMaxWait) ? tmpMaxWait : "60000";
			
			
			dataBaseProp.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, DB_DRIVER);
			dataBaseProp.put(DruidDataSourceFactory.PROP_URL, DB_URL);
			dataBaseProp.put(DruidDataSourceFactory.PROP_USERNAME, DB_USERNAME);
			dataBaseProp.put(DruidDataSourceFactory.PROP_PASSWORD, DB_PASSWORD);

			dataBaseProp.put(DruidDataSourceFactory.PROP_INITIALSIZE, DB_INITIAL_SIZE);
			dataBaseProp.put(DruidDataSourceFactory.PROP_MAXACTIVE, DB_MAXACTIVE);
			dataBaseProp.put(DruidDataSourceFactory.PROP_MINIDLE, DB_MINIDLE);
			dataBaseProp.put(DruidDataSourceFactory.PROP_MAXWAIT, DB_MAXWAIT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
