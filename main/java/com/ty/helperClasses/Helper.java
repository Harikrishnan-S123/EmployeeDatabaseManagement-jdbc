package com.ty.helperClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
	public static boolean isEmpty() {
		Connection con=ConnectionPool.getConnection();
		boolean flag=false;
		try {
			Statement statement=con.createStatement();
			ResultSet rs;
			rs=statement.executeQuery("select count(*) from employee");
			if(rs.next()) {
				if(rs.getInt(1)>=1)
					flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionPool.recieveConnection(con);
		}
		return flag;
		
	}

}
