package com.flytxt.grapho.entity;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
/**
 * 
 * @author shiju.john
 *
 */
public interface GraphoEntity extends Serializable{
	
	/**
	 * 
	 * @return
	 */
	
	@Transient
	@XmlTransient
	@com.fasterxml.jackson.annotation.JsonIgnore
	public Serializable getId();
	 

}
