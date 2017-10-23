package com.flytxt.grapho.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
/**
 * 
 * @author shiju.john
 *
 */
@Table(name="config_data")
@Entity
public class ConfigData implements FlyEntity{

	/**
	 * 
	 */
	
	@Id
	@Column(name="cd_key", length = 100)
	@NotNull
	private String key;
	
	@Column(name="cd_value", length = 300,nullable=false)
	@NotNull
	private String value;
	
	@Column(name="cd_type", length = 20)
	private String type;
	
	@Column(name="cd_remarks", length = 500,nullable=true)
	private String remarks;
	
	
	private static final long serialVersionUID = 1L;

	@Override
	@Transient
	@XmlTransient
	@com.fasterxml.jackson.annotation.JsonIgnore
	public Serializable getId() {
		return getKey();
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
