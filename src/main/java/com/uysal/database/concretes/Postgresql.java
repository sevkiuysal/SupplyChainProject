package com.uysal.database.concretes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.uysal.database.abstracts.ConnectionService;

public class Postgresql  implements ConnectionService{
	
	
	public Postgresql() {
		
	}

	public Connection connect() {
		String url="jdbc:postgresql://localhost/uysaldb";
		String user="postgres";
		String password="sevkiuysal";
		
		String driver="org.postgresql.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection=null;
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
