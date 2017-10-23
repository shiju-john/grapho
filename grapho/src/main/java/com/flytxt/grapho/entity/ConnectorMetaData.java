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
 * 
 * @author shiju.john
 *
 */
@Entity
@Table(name = "connector_metadata")
public class ConnectorMetaData implements FlyEntity{

	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cm_id")
	private long connectorMetaId;
	
	@NotNull(message="error.common.notnull")
	@Column(name= "cm_name" , unique= true , length = 100)
	@Size(max=100,message="Name should be less than 100 characters")
	private String connectorName;
	
	
	@NotNull(message="error.common.notnull")	
	@Lob
	@Column(name= "cm_config")
	private String config;
	
	
	@NotNull(message="error.common.notnull")
	@Lob
	@Column(name= "cm_template")
	private String configTemplate;
	
	
	
	@Column(length = 1000 , name="cm_regex")
	@Size(max=1000, message="Reg Expression should be less than 1000 charcters")
	private String  validationRegEx;


	/**
	 * @return the connectorName
	 */
	public String getConnectorName() {
		return connectorName;
	}


	/**
	 * @param connectorName the connectorName to set
	 */
	public void setConnectorName(String connectorName) {
		this.connectorName = connectorName;
	}


	/**
	 * @return the connectorMetaId
	 */
	public long getConnectorMetaId() {
		return connectorMetaId;
	}


	/**
	 * @param connectorMetaId the connectorMetaId to set
	 */
	public void setConnectorMetaId(long connectorMetaId) {
		this.connectorMetaId = connectorMetaId;
	}


	/**
	 * @return the config
	 */
	public String getConfig() {
		return config;
	}


	/**
	 * @param config the config to set
	 */
	public void setConfig(String config) {
		this.config = config;
	}


	/**
	 * @return the configTemplate
	 */
	public String getConfigTemplate() {
		return configTemplate;
	}


	/**
	 * @param configTemplate the configTemplate to set
	 */
	public void setConfigTemplate(String configTemplate) {
		this.configTemplate = configTemplate;
	}


	/**
	 * @return the validationRegEx
	 */
	public String getValidationRegEx() {
		return validationRegEx;
	}


	/**
	 * @param validationRegEx the validationRegEx to set
	 */
	public void setValidationRegEx(String validationRegEx) {
		this.validationRegEx = validationRegEx;
	}


	@Override
	@Transient
	@XmlTransient
	@com.fasterxml.jackson.annotation.JsonIgnore
	public Serializable getId() {
		return connectorMetaId;
	}

}
