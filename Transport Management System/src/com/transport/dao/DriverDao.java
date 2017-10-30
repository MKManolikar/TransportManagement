package com.transport.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.transport.db.DBConnection;
import com.transport.model.Driver;

public class DriverDao {

	
	
	private static Connection conn = null;

	private static String addQuery="insert into [Transport].[dbo].[Driver] values(?,?,?)";
	private static String deleteQuery="delete from [Transport].[dbo].[Driver] where Driver_id=?";
	private static String getOneQuery="select * from [Transport].[dbo].[Driver] where Driver_id=?";
	private static String getAllQuery="select * from [Transport].[dbo].[Driver]";
	private static String updateQuery="update [Transport].[dbo].[Driver] set driver_name=?,  driver_contact=?  where driver_id=?";

	private static DBConnection DBconnection;

	/**
	 * 
	 * @author User
	 * @param driver_id,driver_name,driver_contact
	 * @method addDriver
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int addDriver(Driver driver) throws IOException, SQLException{
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, driver.getDriverId());
			pps.setString(2, driver.getDriverName());
			pps.setInt(3, driver.getDriverContact());

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;
	} //add driver method
	/**
	 * 
	 * @author User
	 * @param driver_id,driver_name,driver_contact
	 * @method getDriver
	 * @return Driver
	 * @throws IOException
	 * 
	 *
	 */
	public Driver getDriver(int id) throws IOException {
		Driver driver = null;
		

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, id);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int driverId = resultSet.getInt(1);
				String driverName= resultSet.getString(2);
				int driverContact = resultSet.getInt(3);
				
				
				driver=new Driver(driverId,driverName,driverContact);
				return driver;
			}//while

		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}//catch
		return driver;
	}// get a particular details of driver
	
	/**
	 * 
	 * @author User
	 * @param driver_id,driver_name,driver_contact
	 * @method getalldriver
	 * @return driver
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */

	public static List<Driver> getDriverDetails() throws IOException, SQLException {
		List<Driver> list = new ArrayList<Driver>();
		conn = DBConnection.getConnection();
		Driver driver = new Driver();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int driverId = resultSet.getInt(1);
				String driverName = resultSet.getString(2);
				int driverContact = resultSet.getInt(3);
				
				driver.setDriverId(driverId);
				
				driver.setDriverName(driverName);				
				driver.setDriverContact(driverContact);
				
				
				Driver driver1=new Driver(driverId,driverName,driverContact);
				list.add(driver1);
			}//while
			return list;

		}//try
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return list;
	}// get all details of driver
	/**
	 * 
	 * @author User
	 * @param driver_id,driver_name,driver_contact
	 * @method updateDriver
	 * @return Integer
	 * @throws IOException
	 * 
	 *
	 */
	public static int updateDriver(int driverId,String driverName,int driverContact) throws IOException {
		System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);
			
			pps.setString(1, driverName);
			pps.setInt(2, driverContact);
			pps.setInt(3, driverContact);

			int rowUpdated = pps.executeUpdate();
			System.out.println(rowUpdated);
			if (rowUpdated == 1)
				return 1;

		}//try
		catch (SQLException e) {
			e.printStackTrace();
		}//catch
		return 0;
	}//update driver details
	/**
	 * 
	 * @author User
	 * @param driver_id,driver_name,driver_contact
	 * @method deleteDriver
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int deleteDriver(int Id)throws IOException, SQLException
	{
		conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(deleteQuery);
			statement.setInt(1, Id);
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated==1)
				return 1;
			
		} //try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;	
	}//delete driver method
	

}//class

	
	
	

