package com.au.advjava;

import java.util.Random; 
import java.util.*;
import java.io.*;
import java.sql.*;

public class AdvJavaAssignmentSoln {
	
	// Having three operations to be performed.
	// 1) Random Number Generation and adding to file.
	// 2) Stream operation and reading from file.
	// 3) Database operation.
	public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {
		// Random Number Generation and adding to file.
		FileInputStream input;
		FileOutputStream output;
		Random rand = new Random();
		output = new FileOutputStream("test.txt");
		input = new FileInputStream("test.txt");
		while(true) {
			int number=rand.nextInt(100);
			output.write(number);
			if(number==0 || number%5==0) {
				break;
			}
		}
		// Stream operation and reading from file.
		List<Integer> myNums = new ArrayList<Integer>();
		int temp;
		while((temp = input.read()) != -1) {
			myNums.add(temp);
		}
		System.out.println(myNums.toString());
		input.close();
		output.close();
		Integer dBId = 
				
				 myNums
				.stream()
				.filter(e -> e%5 == 0)
				.map(e -> e*2)
				.reduce( 1 , (a,b) -> {
					return a*b;
				} );
		System.out.println(dBId);
		// Database operation.
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
		
		// jdbc:mysql:// server-name : server-port / database-name
		// localhost:3306/database
		
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		Statement statement = connection.createStatement();
        String sql = "insert into test values (" + dBId + ",'Akshat')";
        statement.executeUpdate(sql);
        ResultSet result = statement.executeQuery("select * from test");	
		while(result.next()) 
		{
		    String id = result.getString("id");
		    String name = result.getString("name");
		    System.out.println(id+ " "+name); 
		}
//        connection.close();
		
	}

}
