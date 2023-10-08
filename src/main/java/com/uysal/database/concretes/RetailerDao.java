package com.uysal.database.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uysal.database.abstracts.ConnectionService;
import com.uysal.entities.Product;
import com.uysal.entities.Retailer;

public class RetailerDao {

	private ConnectionService connectionService;

	public RetailerDao(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	public int Login(String name, String password) {
		int result=0;
		Connection connection = connectionService.connect();
		String sql = "select *from Retailer where name=? and password=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				result=resultSet.getInt("retailerid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean Register(Retailer retailer) {

		int counter = 0;
		boolean result = false;

		Connection connection = connectionService.connect();
		String sql = "INSERT INTO public.retailer(\r\n"
				+ "	name, email_address, phone_number, password)\r\n"
				+ "	VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, retailer.getName());
			statement.setString(2, retailer.getEmailAddress());
			statement.setLong(3, retailer.getPhoneNumber());
			statement.setString(4, retailer.getPassword());
			counter = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (counter != 0)
			result = true;
		return result;
	}

	public List<Product> viewProducts(long retailerId) {
		Connection connection = connectionService.connect();
		Product product = null;
		List<Product> products = new ArrayList();
		String sql = "select * from billing b where retailer_id =?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, retailerId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				long productId = resultSet.getLong("product_id");
				String productName = resultSet.getString("productName");
				double price = resultSet.getDouble("productPrice");
				long quantity = resultSet.getLong("quantity");
				String image = resultSet.getString("image");

				product = new Product(productId, productName, quantity, price, image);
				products.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	
}
