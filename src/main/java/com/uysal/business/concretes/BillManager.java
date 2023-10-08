package com.uysal.business.concretes;

import com.uysal.business.abstracts.BillService;
import com.uysal.database.concretes.BillDao;
import com.uysal.entities.Bill;

public class BillManager implements BillService {

	private BillDao billDao;
	
	public BillManager(BillDao billDao) {
		this.billDao = billDao;
	}


	@Override
	public boolean generateBill(long retailerId, long productId, int productQuantity) {
		return billDao.createBill(retailerId,productId,productQuantity);
	}

}
