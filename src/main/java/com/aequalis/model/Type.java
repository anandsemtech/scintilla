/**
 * 
 */
package com.aequalis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author leoanbarasanm
 *
 */
@Entity
@Table(name="types")
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeid;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	/**
	 * @return the typeid
	 */
	public Long getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", name=" + name + ", description=" + description + "]";
	}
	
}
