package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utility.JDBCUtility;

public abstract class BaseDao {
	
	QueryRunner runner=new QueryRunner();
	
	public int update(String sql,Object...args) {
		Connection conn = null;
		try {
			
			conn = JDBCUtility.getDB();
			return runner.update(conn, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public <T>T queryForOne(Class<T>type,String sql,Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtility.getDB();
			BeanHandler<T> handler = new BeanHandler<T>(type);
			return runner.query(conn, sql, args, handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public <T>List<T> queryForAll(Class<T>type,String sql,Object...args){
		Connection conn = null;
		try {
			conn = JDBCUtility.getDB();
			BeanListHandler<T> handler = new BeanListHandler<T>(type);
			return runner.query(conn, sql, args, handler);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Object queryForSingle(String sql,Object...args) {
		Connection conn = null;
		try {
			conn = JDBCUtility.getDB();
			ScalarHandler handler = new ScalarHandler();
			return runner.query(conn, sql, handler,args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
