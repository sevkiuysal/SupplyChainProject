package com.uysal.business.abstracts;


import java.util.List;

import com.uysal.entities.Bill;
import com.uysal.entities.Supplier;

public interface SupplierService {

	public Supplier Login(String email, String password);

	public boolean Register(Supplier supplier);
	
	public List<Bill> showBill(long SupplierId);
	
	public List<Bill> pastInvoices(long SupplierId);
	
	public boolean acceptBill(long billId);
	
	public boolean cancelBill(long billId);
	
}
