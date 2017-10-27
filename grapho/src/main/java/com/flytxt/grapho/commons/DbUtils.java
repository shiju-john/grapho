package com.flytxt.grapho.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flytxt.grapho.entity.ResultEntity;
import com.flytxt.grapho.exception.GraphoException;
/**
 * 
 * @author shiju.john
 *
 */
@Deprecated
public class DbUtils {
	
	public static Connection getConnection(String driverName,
			String connectionUrl,String userName,String password) throws GraphoException{
		
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(connectionUrl, 
					userName, password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GraphoException(e.getMessage(), e);
		}	
		
	}
	
	/**
	 * 
	 * @param conn
	 * @param sqlQuery
	 * @return
	 * @throws GraphoException
	 */
	public static ResultEntity getQueryResult(Connection conn, String sqlQuery) throws GraphoException {
		
		Statement st =null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			return resultSetToEntity(rs);
		} catch (SQLException e) {
			throw new GraphoException("Unable to execute SQL query", e);
		}finally{
			closeResources(rs,st);
		}
       
		
	}
	
	/**
	 * 
	 * @param resources
	 * @throws GraphoException
	 */
	private static void closeResources(AutoCloseable ...resources) throws GraphoException {
		for(AutoCloseable closeable : resources){
			close(closeable);
		}
	}
	
	/**
	 * 
	 * @param closeable
	 * @throws GraphoException
	 */
	public static void close(AutoCloseable closeable) throws GraphoException {
		try {
			if (null!= closeable){		
				closeable.close();
			}
		} catch (Exception e) {
			throw new GraphoException("Unable to close the Database resources", e);
		}
		
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws GraphoException
	 */
	private static ResultEntity resultSetToEntity(ResultSet rs) throws SQLException, GraphoException {
		
	    ResultSetMetaData metaData = rs.getMetaData();	    
	    ResultEntity entity = new ResultEntity();	   
	    List<String[]> list = new ArrayList<String[]>();	   
	    entity.setHeader(getColumnHeaderArray(metaData));	    
	    while (rs.next()) {
            String[] record = new String[metaData.getColumnCount()];            
            for (int i = 1; i <= metaData.getColumnCount(); i++) {           	
            	record[i-1] = rs.getString(i);
            }            
            list.add(record);
	    }
	    entity.setResult(list);
	    return entity;
	}
	
	
	/**
	 * 
	 * @param metaData
	 * @return
	 * @throws GraphoException
	 */
	private static String[] getColumnHeaderArray(ResultSetMetaData metaData) throws GraphoException {
		 String[] head =null;
		try {
			head = new String[metaData.getColumnCount()];
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
		    	head[i-1] = metaData.getColumnLabel(i);	    	
		    }
			return head;
		} catch (SQLException e) {
			throw new GraphoException("Unable to process the result set", e);
		}		
	}
	
}
