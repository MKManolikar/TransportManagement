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
import com.transport.model.RouteDetails;

public class RouteDetailsDao {

	private static Connection conn = null;

	private static String addQuery="insert into [Transport].[dbo].[RouteDetails] values(?,?)";
	private static String getOneQuery = "select * from [Transport].[dbo].[RouteDetails] where Loc_id=?";
	private static String getAllQuery = "select * from [Transport].[dbo].[RouteDetails]";
	private static String updateQuery="update [Transport].[dbo].[RouteDetails] set Loc_id=?  where Route_no=?";
	private static String deleteQuery="delete from [Transport].[dbo].[RouteDetails] where Loc_id=?";
	
	private static DBConnection DBConnection;

	/**
	 * 
	 * @author User
	 * @param routeNo,locId
	 * @method addRouteDetails
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException 
	 * 
	 *
	 */
	public static int addCabDetails(int routeNo,int locId) throws IOException, SQLException{
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, routeNo);
			pps.setInt(2, locId);			

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
	public static int updateRouteDetails(int routeNo,int locId) throws IOException {
		//System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);
			
			pps.setInt(1, routeNo);
			pps.setInt(2, locId);
			
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
	 * @param loc_id,route_no
	 * @method getRouteDetails1
	 * @return routedetails
	 * @throws IOException
	 * 
	 *
	 */
	public static RouteDetails getRouteDetails1(int no) throws IOException {
		RouteDetails routeDetails = null;
		System.out.println("get Route Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, no);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int locId= resultSet.getInt(1);
				int routeNo = resultSet.getInt(2);
				

				routeDetails = new RouteDetails(locId, routeNo);
				return routeDetails;
			}// while

		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}// catch
		return routeDetails;
	}// get a particular details of route

	/**
	 * 
	 * @author User
	 * @param cab_id,route_no
	 * @method getRouteDetails2
	 * @return routeDetails
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */

	public static List<RouteDetails> getRouteDetails2() throws IOException, SQLException {
		List<RouteDetails> list = new ArrayList<RouteDetails>();
		conn = DBConnection.getConnection();
		RouteDetails routeDetails = new RouteDetails();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int locId = resultSet.getInt(1);
				int routeNo = resultSet.getInt(2);
				

				routeDetails.setLocId(locId);
				routeDetails.setRouteNo(routeNo);
				

				RouteDetails RouteDetails1 = new RouteDetails(locId, routeNo);
				list.add(routeDetails);
			}// while
			return list;

		}// try

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return list;
	}// get all details of routes

}