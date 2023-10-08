package com.uysal.business.abstracts;

import java.util.List;

import com.uysal.entities.Product;

public interface ProductService {

	public List<Product> searchProductbyName(String name);
	
	public Product viewProductDetails(long productId);
	
	public List<Product> getAll();
	
	public List<Product> getAll(long supplierId);
	
	public boolean delete(int productId);
	
	public boolean update(Product product);
	
	public boolean addProduct(Product product);
	
	public Product getProduct(long productId);
}
