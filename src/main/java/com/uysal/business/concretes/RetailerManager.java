package com.uysal.business.concretes;


import java.util.List;

import com.uysal.business.abstracts.RetailerService;
import com.uysal.database.concretes.RetailerDao;
import com.uysal.entities.Product;
import com.uysal.entities.Retailer;

public class RetailerManager implements RetailerService {

	private RetailerDao retailerDao;
	

	public RetailerManager(RetailerDao retailerDao) {
		this.retailerDao = retailerDao;
	}

	public int Login(String name, String password) {
		return retailerDao.Login(name, password);
	}

	public boolean Register(Retailer retailer) {
		return retailerDao.Register(retailer);
	}

	
	public List<Product> viewProducts(long retailerId) {
		return retailerDao.viewProducts(retailerId);
	}

	
	

}
