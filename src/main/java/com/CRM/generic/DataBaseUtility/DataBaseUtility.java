package com.CRM.generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	 Connection con;
  public void getDBConnection(String url, String UName, String PWD) throws SQLException {
	 
	  try {
	  Driver driver = new Driver();
	 DriverManager.registerDriver(driver);
	con =  DriverManager.getConnection(url, UName, PWD);
	  }catch(Exception e) {}
  }
  public void closeDBConnection() {
	  try {
		  con.close();
	  }catch(Exception e) {}
  }
  public ResultSet executeSelectQuery(String query) {
	  ResultSet result = null;
	  try {
	Statement stat = con.createStatement();
	 result = stat.executeQuery(query);
	  }catch(Exception e) {}
	  return result; 
  }
  public int executeNonSelectQuery(String query) {
	  int result = 0;
	  try {
		 Statement stat = con.createStatement(); 
		result = stat.executeUpdate(query);
	  }catch(Exception e) {}
	  return result;
  }
  public void getDBConnectionParameterized() {
	  try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://localhost:3333/ninza_hrm", "root", "root");
				
	  }catch(Exception e) {}
  }
}
