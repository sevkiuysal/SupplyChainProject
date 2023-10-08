package com.uysal.business.concretes;


import java.util.List;

import com.uysal.business.abstracts.ProductService;
import com.uysal.database.concretes.ProductDao;
import com.uysal.entities.Product;

public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}
	

	public ProductManager() {
	}

	
	public List<Product> searchProductbyName(String name) {
		return productDao.getProductsbyName(name);
	}

	
	public Product viewProductDetails(long productId) {
		return productDao.getProduct(productId);
	}


	
	public List<Product> getAll() {
		return productDao.getAll();
	}


	
	public List<Product> getAll(long supplierId) {
		return productDao.getAll(supplierId);
	}


	
	public boolean delete(int productId) {
		return productDao.delete(productId);		
	}


	
	public boolean update(Product product) {
		return productDao.update(product);
		
	}


	
	public Product getProduct(long productId) {
		return productDao.getProduct(productId);
	}


	
	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
		
	}


}
