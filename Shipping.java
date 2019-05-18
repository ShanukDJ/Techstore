package com.emalcoding.springBootREST.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="shipping1")
@EntityListeners(AuditingEntityListener.class)

public class Shipping {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
//	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
//	@NotBlank
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date date;
	
//	@NotBlank
	private Long price;
	
	private Long qtyperunit;

	public Shipping() {
	}
	
	
	

	public Shipping(Long id, String name, String description, Date date, Long price, Long qtyperunit) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.price = price;
		this.qtyperunit = qtyperunit;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}




	public Long getQtyperunit() {
		return qtyperunit;
	}




	public void setQtyperunit(Long qtyperunit) {
		this.qtyperunit = qtyperunit;
	}
	

	
}

