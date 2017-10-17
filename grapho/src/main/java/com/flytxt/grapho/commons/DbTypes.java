package com.flytxt.grapho.commons;

import java.sql.Connection;

import com.flytxt.grapho.entity.JobDetails;
import com.flytxt.grapho.entity.ResultEntity;
import com.flytxt.grapho.exception.GraphoException;

/**
 * 
 * @author shijuj
 *
 */
public enum DbTypes {
	
	MYSQL("MYSQL","com.mysql.jdbc.Driver") {
		@Override
		public ResultEntity executeQuery(JobDetails entity) throws GraphoException {			
			Connection  conn =null;			
			try{				
				conn = DbUtils.getConnection(this.getDriverClass(), entity.getConnectionUrl(), 
						entity.getDbUserName(), entity.getDbPassword());
				return DbUtils.getQueryResult(conn,entity.getSqlQuery());				
			} catch ( GraphoException e) {
				throw e;
			}finally{
				DbUtils.close(conn);			
			}        
		}

		
	},
	ORACLE("ORACLE","") {
		@Override
		public  ResultEntity executeQuery(JobDetails entity) throws GraphoException{
			// TODO Auto-generated method stub
			return null;
		}
	},
	MSSQL("MSSQL","") {
		@Override
		public  ResultEntity executeQuery(JobDetails entity) throws GraphoException{
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	private String key;
	private String driverClass;
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 * @throws GraphoException
	 */
	public abstract  ResultEntity executeQuery(JobDetails jobDetails) throws GraphoException;
	
	private DbTypes(String key,String driverClass){
		this.setKey(key);
		this.setDriverClass(driverClass);
	}

	/**
	 * @return the key
	 */
	private  String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	private void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static DbTypes getDbType(String key){		
		for(DbTypes type : DbTypes.values()){
			if ( type.getKey().equalsIgnoreCase(key )){
				return type;
			}
		}
		return null;		
	}
	
	

	/**
	 * @return the driverClass
	 */
	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * @param driverClass the driverClass to set
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
}
