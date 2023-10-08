package com.uysal.business.abstracts;

import com.uysal.entities.Bill;

public interface BillService {

	public boolean generateBill(long retailerId, long productId, int productQuantity);
}
