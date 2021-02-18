package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;

public class JDBCUtility {
	
	static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
	static DruidDataSource source;
	static {
	
		try {
			InputStream is=JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties pro=new Properties();
			pro.load(is);
			source=(DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getDB() {
		Connection conn = null;
		try {
			conn = source.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
