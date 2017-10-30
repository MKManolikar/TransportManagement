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
import com.transport.model.Location;

public class LocationDao {

	
	
	private static Connection conn = null;

	private static String addQuery="insert into location values(?,?,?)";
	private static String deleteQuery="delete from location where loc_id=?";
	private static String getOneQuery="select * from location where loc_id=?";
	private static String getAllQuery="select * from location";
	
	private static DBConnection DBConnection;

	/**
	 * 
	 * @author User
	 * @param loc_id,loc_name,C_loc
	 * @method addLocation
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int addLocation(Location location) throws IOException, SQLException{
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, location.getLocId());
			pps.setString(2, location.getLocName());
			pps.setInt(3, location.getcLoc());

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;
	} //add location method
	/**
	 * 
	 * @author User
	 * @param loc_id,loc_name,C_loc
	 * @method getLocation
	 * @return location
	 * @throws IOException
	 * 
	 *
	 */
	public static Location getLocation(int id) throws IOException {
		Location location = null;
		System.out.println("get loactions Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, id);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int locId = resultSet.getInt(1);
				String locName= resultSet.getString(2);
				int cLoc = resultSet.getInt(3);
				
				
				location=new Location(locId,locName,cLoc);
				return location;
			}//while

		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}//catch
		return location;
	}// get a particular details of location
	
	/**
	 * 
	 * @author User
	 * @param loc_id,loc_name,C_loc
	 * @method getAllLocations
	 * @return locations
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */

	public static List<Location> getLocationDetails() throws IOException, SQLException {
		List<Location> list = new ArrayList<Location>();
		conn = DBConnection.getConnection();
		Location location = new Location();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int locId = resultSet.getInt(1);
				String locName = resultSet.getString(2);
				int cLoc = resultSet.getInt(3);
				
				location.setLocId(locId);	
				location.setLocName(locName);				
				location.setcLoc(cLoc);
				
				
				Location location1=new Location(locId,locName,cLoc);
				list.add(location1);
			}//while
			return list;

		}//try
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return list;
	}// get all details of all the locations
	
	
	
	
	/**
	 * 
	 * @author User
	 * @param loc_id,loc_name,C_loc
	 * @method deletelocation
	 * @return int
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	
	
	
	
	public static int deleteLocation(int Id)throws IOException, SQLException
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
	}//delete location method
	

}//class

	
	
	

