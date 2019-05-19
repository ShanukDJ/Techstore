/**
 * 
 */
package com.sellnbye.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Hemachandra
 *
 */

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String type;

	public Type() {

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
