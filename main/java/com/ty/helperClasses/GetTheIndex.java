
package com.ty.helperClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTheIndex {
	
	public static int getLastRowIndex(Connection connection) {
		
		
		String sql = "SELECT eid FROM employee ORDER BY eid DESC LIMIT 1";
		int index = 1;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				String temp = resultSet.getString(1);
				String in = temp.substring(3);
				
				index = Integer.parseInt(in);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return index;
		
		
	}

}
