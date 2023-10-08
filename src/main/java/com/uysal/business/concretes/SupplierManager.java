package com.uysal.business.concretes;

import java.util.List;

import com.uysal.business.abstracts.SupplierService;
import com.uysal.database.concretes.SupplierDao;
import com.uysal.entities.Bill;
import com.uysal.entities.Supplier;

public class SupplierManager implements SupplierService {

	private SupplierDao supplierDao;

	public SupplierManager(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	@Override
	public Supplier Login(String email, String password) {
		return supplierDao.Login(email, password);
	}

	@Override
	public boolean Register(Supplier supplier) {
		return supplierDao.Register(supplier);
	}

	@Override
	public List<Bill> showBill(long supplierId) {
		return supplierDao.showBill(supplierId,0);
	}
	
	@Override
	public List<Bill> pastInvoices(long supplierId) {
		return supplierDao.showBill(supplierId,1);
	}

	@Override
	public boolean acceptBill(long billId) {
		return supplierDao.acceptBill(billId);
	}

	@Override
	public boolean cancelBill(long billId) {
		return supplierDao.cancelBill(billId);
	}
	
	
	
}
