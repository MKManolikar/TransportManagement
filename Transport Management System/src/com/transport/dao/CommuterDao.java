package com.transport.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.transport.db.DBConnection;
import com.transport.model.Commuter;

public class CommuterDao {

	
	
	private static Connection conn = null;

	private static String addQuery="insert into [Transport].[dbo].[Commuter] values(?,?,?,?)";
	private static String deleteQuery="delete from [Transport].[dbo].[Commuter] where C_id=?";
	private static String getOneQuery="select * from [Transport].[dbo].[Commuter] where C_id=?";
	private static String getAllQuery="select * from [Transport].[dbo].[Commuter]";
	private static String updateQuery="update [Transport].[dbo].[Commuter] set C_name=?, C_loc=?, C_contact=?  where C_id=?";

	private static DBConnection DBConnection;
	/**
	 * 
	 * @author User
	 * @param c_id,c_name,c_loc,c_contact
	 * @method addCommuter
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int addCommuter(Commuter commuter) throws IOException, SQLException{
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, commuter.getcId());
			pps.setString(2, commuter.getcName());
			pps.setInt(3, commuter.getcLoc());
			pps.setInt(2, commuter.getcContact());

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;
	} //add commuter method
	/**
	 * 
	 * @author User
	 * @param c_id,c_name,c_loc,c_contact
	 * @method getCommuter
	 * @return commuter
	 * @throws IOException
	 * 
	 *
	 */
	public static Commuter getCommuter(int id) throws IOException {
		Commuter commuter = null;
		System.out.println("get Commuter Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, id);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cId = resultSet.getInt(1);
				String cName= resultSet.getString(2);
				int cLoc = resultSet.getInt(3);
				int cContact = resultSet.getInt(4);
				
				
				commuter=new Commuter(cId,cName,cLoc,cContact);
				return commuter;
			}//while

		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}//catch
		return commuter;
	}// get a particular details of commuter
	
	/**
	 * 
	 * @author User
	 * @param c_id,c_name,c_loc,c_contact
	 * @method getCommuterDetails
	 * @return Commuter
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */

	public static List<Commuter> getCommuterDetails() throws IOException, SQLException {
		List<Commuter> list = new ArrayList<Commuter>();
		conn = DBConnection.getConnection();
		Commuter commuter = new Commuter();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cId = resultSet.getInt(1);
				String cName = resultSet.getString(2);
				int cLoc = resultSet.getInt(3);
				int cContact = resultSet.getInt(4);
				
				commuter.setcId(cId);
				
				commuter.setcName(cName);
				commuter.setcLoc(cLoc);
				commuter.setcContact(cContact);
				
				
				Commuter commuter1=new Commuter(cId,cName,cLoc,cContact);
				list.add(commuter1);
			}//while
			return list;

		}//try
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return list;
	}// get all details of commuter
	/**
	 * 
	 * @author User
	 * @param c_id,c_name,c_loc,c_contact
	 * @method updateCommuter
	 * @return Integer
	 * @throws IOException
	 * 
	 *
	 */
	public static int updateCommuter(int cId,String cName,int cLoc, int cContact) throws IOException {
		//System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);
			
			pps.setString(1, cName);
			pps.setInt(2, cLoc);
			pps.setInt(3, cContact);

			int rowUpdated = pps.executeUpdate();
			System.out.println(rowUpdated);
			if (rowUpdated == 1)
				return 1;

		}//try
		catch (SQLException e) {
			e.printStackTrace();
		}//catch
		return 0;
	}//update commuter details
	/**
	 * 
	 * @author User
	 * @param c_id,c_name,c_loc,c_contact
	 * @method deleteCommuter
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int deleteCommuter(int cId)throws IOException, SQLException
	{
		conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(deleteQuery);
			statement.setInt(1, cId);
			int rowsUpdated = statement.executeUpdate();
			if(rowsUpdated==1)
				return 1;
			
		} //try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;	
	}//delete commuter method
	

}//class

	
	
	

