package com.uysal.database.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uysal.database.abstracts.ConnectionService;
import com.uysal.entities.Bill;
import com.uysal.entities.Supplier;

public class SupplierDao {

private ConnectionService connectionService;
	


	public SupplierDao(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	public Supplier Login(String name, String password) {
		Supplier supplier=new Supplier();
		int userId=0;
		Connection connection=connectionService.connect();
		String sql="select * from Supplier where name =? and password =?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet resultSet=statement.executeQuery();
			if(resultSet.next()) {
				userId=resultSet.getInt("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		supplier.setName(name);
		supplier.setPassword(password);
		supplier.setUserId(userId);
		return supplier;
	}

	
	public boolean Register(Supplier supplier) {
		boolean result=false;
		
		Connection connection = connectionService.connect();
		String sql = "insert into Supplier(name,email,phone,password)values(?,?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, supplier.getName());
			statement.setString(2, supplier.getEmailAddress());
			statement.setLong(3, supplier.getPhoneNumber());
			statement.setString(4, supplier.getPassword());
			if(statement.executeUpdate()>0)
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Bill> showBill(long supplierId, int sellStatus){
		List<Bill> bills=new ArrayList<>();
		
		Connection connection=connectionService.connect();
		
		String sql="select b.bill_id , p.\"productName\" ,r.\"name\" ,b.product_quantity ,p.\"productPrice\" "
				+ ",p.\"productPrice\" *b.product_quantity \r\n"
				+ "as \"total_amount\" from billing b  \r\n"
				+ "inner join product p on b.product_id =p.\"productId\" \r\n"
				+ "inner join retailer r on b.retailer_id =r.retailerid\r\n"
				+ "inner join supplier s on p.userid =s.userid and b.sell_status=? and s.userid =?";
		
		PreparedStatement statement;
		
		try {
			
			statement=connection.prepareStatement(sql);
			
			statement.setInt(1, sellStatus);
			statement.setLong(2, supplierId);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()) {
				long billId=resultSet.getLong("bill_id");
				String retailerName=resultSet.getString("name");
				String productName=resultSet.getString("productName");
				double productPrice=resultSet.getDouble("productPrice");
				long productQuantity=resultSet.getLong("product_quantity");
				double totalAmount=resultSet.getDouble("total_amount");
				
				
				Bill bill=new Bill(billId, retailerName, productName, productPrice, productQuantity,totalAmount);
				
				bills.add(bill);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bills;
	}
	
	public boolean acceptBill(long billId) {
		boolean result=false;
		
		Connection connect=connectionService.connect();
		String sql="update billing  set sell_status  =1 where bill_id =?";
		PreparedStatement statement;
		try {
			statement=connect.prepareStatement(sql);
			statement.setLong(1, billId);
			if(statement.executeUpdate()>0)
				result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public boolean cancelBill(long billId) {
		boolean result=false;
		Connection connect=connectionService.connect();
		String sql="delete from billing where bill_id =?";
		PreparedStatement statement;
		try {
			statement=connect.prepareStatement(sql);
			statement.setLong(1, billId);
			if(statement.executeUpdate()>0)
				result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
