package com.beam.learning;

import java.io.Serializable;

// Serializable cz this will run to distributed system
public class Customer implements Serializable{

	private String customerId;
	private String name;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Customer() {
		super();
	}
	
	public Customer(String customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}
}
