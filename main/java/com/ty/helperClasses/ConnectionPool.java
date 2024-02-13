package com.ty.helperClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connectionpool=new ArrayList<Connection>();
	private static String driverPath="org.postgresql.Driver";
	private static String URL="jdbc:postgresql://localhost:5432/employee";
	private static String user="postgres";
	private static String pwd="root";
	private static final int POOL_SIZE=5;
	
	static {
		
			try {
				Class.forName(driverPath);
				for(int i=0;i<POOL_SIZE;i++) {
					Connection connection=createConnection();
					connectionpool.add(connection);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	static Connection createConnection() {
		Connection connection=null;
		
			try {
				connection=DriverManager.getConnection(URL,user,pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return connection;
				
		
	}
	
	public static Connection getConnection() {
		//check list empty or not,if not
		if(!(connectionpool.isEmpty())) {
			return connectionpool.remove(0);//remove one object and give it
		}
		//System.out.println("after taking"+connectionpool.size());
		return createConnection();   //else it will return a newly created connection object
		
	}
	public static void  recieveConnection(Connection con) {
		//pool is not full
		if(connectionpool.size()<POOL_SIZE) {
			connectionpool.add(con);
			//System.out.println("after contribution:"+connectionpool.size());
		}
		else {
			try {
				con.close();
				//System.out.println("after contribution:"+connectionpool.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static int getConnectionpoolSize() {
		return connectionpool.size();
	}
 
}
