package com.uysal.entities;

public class Bill {

	private long billId;
	
	private int sellStatus;
	
	private String productName;
		
	private String retailerName;
	
	private double productPrice;

	private double totalAmount;
	
	private long quantity;
	
	public Bill() {
	}


	public Bill(int sellStatus, String retailerName, String productName, 
			 double productPrice,long quantity, double totalAmount) {
		this.sellStatus = sellStatus;
		this.productName = productName;
		this.retailerName = retailerName;
		this.productPrice = productPrice;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
	}

	public Bill(String retailerName, String productName,  double productPrice,long quantity, double totalAmount) {
		this.productName = productName;
		this.retailerName = retailerName;
		this.productPrice = productPrice;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
	}
	
	public Bill(long billId, String retailerName, String productName, 
			 double productPrice,long quantity, double totalAmount) {
		this.billId = billId;
		this.productName = productName;
		this.retailerName = retailerName;
		this.productPrice = productPrice;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
	}

	
	public long getBillId() {
		return billId;
	}


	public void setBillId(long billId) {
		this.billId = billId;
	}


	public int getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(int sellStatus) {
		this.sellStatus = sellStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	

}
