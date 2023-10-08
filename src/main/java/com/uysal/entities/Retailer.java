package com.uysal.entities;

import java.util.List;

public class Retailer {

	private long retailerId;
	
	private String name;
	
	private String password;
	
	private String emailAddress;
	
	private long phoneNumber;
	
	private List<Product> products;

	private Product product;
	
	public Retailer() {
		
	}

	public Retailer(String name, String password, String emailAddress, long phoneNumber) {
		
		this.name = name;
		this.password = password;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public Retailer(long retailerId, String name, String password, String emailAddress, long phoneNumber,
			Product product) {
		this.retailerId = retailerId;
		this.name = name;
		this.password = password;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.product = product;
	}
	
	public Retailer(long retailerId,List<Product> products) {
		this.retailerId = retailerId;
		this.products = products;
	}

	public long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(long retailerId) {
		this.retailerId = retailerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
