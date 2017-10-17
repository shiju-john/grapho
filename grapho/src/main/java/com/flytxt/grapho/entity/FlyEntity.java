package com.flytxt.grapho.entity;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;
/**
 * 
 * @author shijuj
 *
 */
public interface FlyEntity extends Serializable{
	
	/**
	 * 
	 * @return
	 */
	@Transient
	@XmlTransient
	public Serializable getId();
	 

}
