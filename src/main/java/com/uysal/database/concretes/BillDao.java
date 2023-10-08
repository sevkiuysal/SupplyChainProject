package com.uysal.database.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.uysal.database.abstracts.ConnectionService;
import com.uysal.entities.Bill;

public class BillDao {
	
	private ConnectionService connectionService;

	public BillDao(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	public boolean createBill(long retailerId, long productId, int productQuantity) {
boolean result=false;
		
		Connection connection=connectionService.connect();
		
		String sql="INSERT INTO public.billing(\r\n"
				+ " retailer_id, product_id, product_quantity)\r\n"
				+ "	VALUES ( ?, ?, ?)";
		PreparedStatement statement;
		
		
		try {
			statement=connection.prepareStatement(sql);
			
				statement.setLong(1, retailerId);
				statement.setLong(2, productId);
				statement.setInt(3, productQuantity);
				if(statement.executeUpdate()>0)
					result=true;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
