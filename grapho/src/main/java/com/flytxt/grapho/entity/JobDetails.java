package com.flytxt.grapho.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author shiju.john
 *
 */

@Entity
@Table(name ="job_details")
public class JobDetails  implements GraphoEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long jobId;
	
	@NotNull
	@Column(length = 100)
	@Size(max=100,message="Name should be less than 100 characters")
	private String jobName;
	
	@NotNull	
	@Column(length = 10)
	@Size(max=10,message="MaxLength exceeds(10)")
	private String dbType;
	
	
	@NotNull
	@Column(length = 100)
	@Size(max=100,message="MaxLength exceeds(100)")
	private String dbUserName;
	
	@Column(length = 35)
	@NotNull
	@Size(max=35,message="MaxLength exceeds(35)")
	private String dbPassword;
	
	@Column(length = 250)
	@NotNull
	private String connectionUrl;
	 
	@Column(length=2000)
	@NotNull
	@Size(max=2000,message="MaxLength exceeds(2000)")
	private String sqlQuery;
	
	@Lob
	private byte[] chartData;

	
	
	/**
	 * @return the jobId
	 */
	public long getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the dbUserName
	 */
	public String getDbUserName() {
		return dbUserName;
	}

	/**
	 * @param dbUserName the dbUserName to set
	 */
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	/**
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * @param dbPassword the dbPassword to set
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
	 * @return the connectionUrl
	 */
	public String getConnectionUrl() {
		return connectionUrl;
	}

	/**
	 * @param connectionUrl the connectionUrl to set
	 */
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	/**
	 * @return the sqlQuery
	 */
	public String getSqlQuery() {
		return sqlQuery;
	}

	/**
	 * @param sqlQuery the sqlQuery to set
	 */
	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	/**
	 * @return the chartData
	 */
	public byte[] getChartData() {
		return chartData;
	}

	/**
	 * @param chartData the chartData to set
	 */
	public void setChartData(byte[] chartData) {
		this.chartData = chartData;
	}

	/**
	 * @return the dbType
	 */
	public String getDbType() {
		return dbType;
	}

	/**
	 * @param dbType the dbType to set
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	@Override
	public Serializable getId() {
		return jobId;
	}
	
	
	
}
