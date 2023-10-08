package com.uysal.database.concretes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uysal.database.abstracts.ConnectionService;
import com.uysal.entities.Product;

public class ProductDao {
	
	private ConnectionService connectionService;
	
	public ProductDao(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	public ProductDao() {
		
	}

	public boolean addProduct(Product product) {
		Connection connection=connectionService.connect();
		String sql="INSERT INTO public.product(\r\n"
				+ " \"productName\", quantity, \"productPrice\", userid, image)\r\n"
				+ "	VALUES ( ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		int update=0;
		boolean result=false;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setLong(2, product.getQuantity());
			statement.setDouble(3, product.getPrice());
			statement.setLong(4, product.getUserId());
			statement.setString(5, product.getImage());
			update=statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update>0)
			result=true;
		return result;
	}
	
	public boolean delete(long productId) {
		Connection connection=connectionService.connect();
		String sql="DELETE FROM public.product\r\n"
				+ "	WHERE \"productId\"=?";
		PreparedStatement statement;
		boolean result=false;
		int update=0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, productId);
			update=statement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update>0)
			result= true;
		return result;
	}
	
	public boolean update(Product product) {
		Connection connection=connectionService.connect();
		String sql="UPDATE public.product\r\n"
				+ "	SET \"productName\"=?, quantity=?, \"productPrice\"=?,  image=?\r\n"
				+ "	WHERE  \"productId\"=? ";
		PreparedStatement statement;
		int update=0;
		boolean result=false;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, product.getProductName());
			statement.setLong(2, product.getQuantity());
			statement.setDouble(3, product.getPrice());
			statement.setString(4, product.getImage());
			statement.setLong(5, product.getProductId());
			update=statement.executeUpdate();
			connection.close();
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update>0)
			result=true;
		return result;
	}
	
	public Product getProduct(long productId) {
		Connection connection=connectionService.connect();
		Product product=null;
		String sql="select *from Product where \"productId\"=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, productId);
			ResultSet resultSet=statement.executeQuery();
			
			if(resultSet.next())
			{
				product=convertToProduct(resultSet);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return product;
	}
	
	public List<Product> getAll(){
		Connection connection=connectionService.connect();
		Product product=null;
		List<Product> products=new ArrayList();
		String sql="select *from Product";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				product=convertToProduct(resultSet);
				products.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return products;
	}
	
	public List<Product> getAll(long supplierId){
		Connection connection=connectionService.connect();
		Product product=null;
		List<Product> products=new ArrayList();
		String sql="select *from Product where userid=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, supplierId);
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				product=convertToProduct(resultSet);
				products.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return products;
	}
	public List<Product> getProductsbyName(String name){
		
		Connection connection=connectionService.connect();
		Product product=null;
		List<Product> products=new ArrayList();
		String sql="select *from Product where \"productName\" like ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%"+name+"%");
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				product=convertToProduct(resultSet);
				products.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return products;
	}
	
	Product convertToProduct(ResultSet resultSet) throws SQLException {
		
		long productId=resultSet.getLong("productId");
		String productName=resultSet.getString("productName");
		double price=resultSet.getDouble("productPrice");
		long quantity=resultSet.getLong("quantity");
		String image=resultSet.getString("image");
		
		Product product=new Product(productId, productName, quantity, price,image);
		return product;
	}
}
