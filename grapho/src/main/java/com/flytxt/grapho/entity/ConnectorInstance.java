package com.flytxt.grapho.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
/**
 * @author shiju.john
 */
@Entity
@Table(name = "connector_instance")
public class ConnectorInstance implements FlyEntity {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "ci_id")
	private long instanceId;
	
	@NotNull(message="error.ci.notnull")
	@Column(name= "ci_name" , unique= true , length = 100)
	@Size(max=100,message="Name should be less than 100 characters")
	private String instanceName;
	
	@NotNull(message="error.common.notnull")
	@Column(name = "ci_cm_ref_id")
	private Long connectorRefId;
	
	@NotNull(message="error.common.notnull")
	@Lob
	@Column(name = "ci_config")
	private String instanceConfig;

 
	@NotNull(message="error.common.notnull")
	@Column(name= "ci_script_type" , unique= true , length = 50)
	@Size(max=50,message="Name should be less than 50 characters")
	private String scriptType;
	
	/**
	 * @return the instanceId
	 */
	public long getInstanceId() {
		return instanceId;
	}


	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(long instanceId) {
		this.instanceId = instanceId;
	}



	/**
	 * @return the instanceName
	 */
	public String getInstanceName() {
		return instanceName;
	}


	/**
	 * @param instanceName the instanceName to set
	 */
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


	/**
	 * @return the connectorRefId
	 */
	public Long getConnectorRefId() {
		return connectorRefId;
	}


	/**
	 * @param connectorRefId the connectorRefId to set
	 */
	public void setConnectorRefId(Long connectorRefId) {
		this.connectorRefId = connectorRefId;
	}


	/**
	 * @return the instanceConfig
	 */
	public String getInstanceConfig() {
		return instanceConfig;
	}


	/**
	 * @param instanceConfig the instanceConfig to set
	 */
	public void setInstanceConfig(String instanceConfig) {
		this.instanceConfig = instanceConfig;
	}


	/**
	 * @return the scriptType
	 */
	public String getScriptType() {
		return scriptType;
	}


	/**
	 * @param scriptType the scriptType to set
	 */
	public void setScriptType(String scriptType) {
		this.scriptType = scriptType;
	}


	@Override
	@Transient
	@XmlTransient
	public Serializable getId() {
		return instanceId;
	}
	
}
