package com.uysal.business.abstracts;

import java.util.List;

import com.uysal.entities.Product;
import com.uysal.entities.Retailer;

public interface RetailerService {

	public int Login(String name, String password);
	
	public boolean Register(Retailer retailer);
	
	public List<Product> viewProducts(long retailerId);
	
}
