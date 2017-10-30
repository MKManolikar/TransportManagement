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
import com.transport.model.Cab;
import com.transport.model.CabDetails;
import com.transport.model.Commuter;

public class CabDetailsDao {

	private static Connection conn = null;

	private static String addQuery="insert into [Transport].[dbo].[CabDetails] values(?,?)";
	private static String getOneQuery = "select * from [Transport].[dbo].[CabDetails] where Cab_no=?";
	private static String getAllQuery = "select * from [Transport].[dbo].[CabDetails] ";
	private static String updateQuery="update [Transport].[dbo].[CabDetails] set C_id=?  where Cab_no=?";
	private static String deleteQuery="delete from [Transport].[dbo].[CabDetails] where C_id=?";
	
	private static DBConnection DBConnection;

	/**
	 * 
	 * @author User
	 * @param cabNo,cId
	 * @method addCabDetails
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int addCabDetails(int cabNo,int cId) throws IOException, SQLException{
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, cabNo);
			pps.setInt(2, cId);			

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		return 0;
	} //add CabDetails method
	
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
	public static int updateCabDetails(int cabNo,int cId) throws IOException {
		//System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);
			
			pps.setInt(1, cabNo);
			pps.setInt(2, cId);
			
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
	public static int deleteCabdetails(int cId)throws IOException, SQLException
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
	
	
	
	/**
	 * 
	 * @author User
	 * @param cab_no,Cab_id
	 * @method getCabDetails
	 * @return cab
	 * @throws IOException
	 * 
	 *
	 */
	public static CabDetails getCabDetails(int no) throws IOException {
		CabDetails cabDetails = null;
		System.out.println("get Cab Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, no);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cabId= resultSet.getInt(1);
				int cabNo = resultSet.getInt(2);
				

				cabDetails = new CabDetails(cabId, cabNo);
				return cabDetails;
			}// while

		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}// catch
		return cabDetails;
	}// get a particular details of cab

	/**
	 * 
	 * @author User
	 * @param cab_no,driver_id,route_no
	 * @method getCabDetails1
	 * @return cab
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */

	public static List<CabDetails> getAllCabDetails() throws IOException, SQLException {
		List<CabDetails> list = new ArrayList<CabDetails>();
		conn = DBConnection.getConnection();
		CabDetails cabDetails = new CabDetails();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cabId = resultSet.getInt(1);
				int cabNo = resultSet.getInt(2);
				

				cabDetails.setCabId(cabId);
				cabDetails.setCabNo(cabNo);
				

				CabDetails cabDetails1 = new CabDetails(cabNo, cabId);
				list.add(cabDetails1);
			}// while
			return list;

		}// try

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return list;
	}// get all details of cabs

}