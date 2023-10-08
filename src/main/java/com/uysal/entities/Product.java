package com.uysal.entities;

public class Product {

	private long productId;

	private String productName;

	private long quantity;

	private double price;

	private String image;

	private long userId;

	public Product() {

	}

	public Product(long productId, String productName, long quantity, double price, String image, long userId) {

		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.userId = userId;
	}
	
	public Product( String productName, long quantity, double price, String image, long userId) {

		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.userId = userId;
	}

	public Product(long productId, String productName, long quantity, double price, String image) {

		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
	}
	
	public Product(long productId, String productName, long quantity, double price) {

		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(String productName, long quantity, double price) {

		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
