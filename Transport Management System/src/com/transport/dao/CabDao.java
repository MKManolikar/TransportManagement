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

public class CabDao {

	private static Connection conn = null;

	private static String addQuery = "insert into cab values(?,?,?)";      //Add
	private static String deleteQuery = "delete from cab where cab_no=?";
	private static String getOneQuery = "select * from cab where cab_no=?";
	private static String getAllQuery = "select * from cab";
	private static String updateQuery = "update cab set driver_id=?, route_no=? where cab_no=?";

	private static DBConnection DBConnection;

	/**
	 * 
	 * @author User
	 * @param cab_no,driver_id,route_no
	 * @method addNewCabDetails
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */
	public static int addCab(Cab cab) throws IOException, SQLException {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, cab.getCabNo());
			pps.setInt(2, cab.getDriverId());
			pps.setInt(3, cab.getRouteNo());

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return 0;
	} // add cab method

	/**
	 * 
	 * @author User
	 * @param cab_no
	 *            ,driver_id,route_no
	 * @method getCabDetails
	 * @return cab
	 * @throws IOException
	 * 
	 *
	 */
	public static Cab getCab(int no) throws IOException {
		Cab cab = null;
		System.out.println("get Cab Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, no);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cabNo = resultSet.getInt(1);
				int driverId = resultSet.getInt(2);
				int routeNo = resultSet.getInt(3);

				cab = new Cab(cabNo, driverId, routeNo);
				return cab;
			}// while

		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}// catch
		return cab;
	}// get a particular details of cab

	/**
	 * 
	 * @author User
	 * @param cab_no
	 *            ,driver_id,route_no
	 * @method getAllCabDetails
	 * @return cab
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */

	public static List<Cab> getCabDetails() throws IOException, SQLException {
		List<Cab> list = new ArrayList<Cab>();
		conn = DBConnection.getConnection();
		Cab cab = new Cab();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int cabNo = resultSet.getInt(1);
				int driverId = resultSet.getInt(2);
				int routeNo = resultSet.getInt(3);

				cab.setCabNo(cabNo);
				cab.setDriverId(driverId);
				cab.setRouteNo(routeNo);

				Cab cab1 = new Cab(cabNo, driverId, routeNo);
				list.add(cab1);
			}// while
			return list;

		}// try

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return list;
	}// get all details of cabs

	/**
	 * 
	 * @author User
	 * @param cab_no
	 *            ,driver_id,route_no
	 * @method updateCabDetails
	 * @return Integer
	 * @throws IOException
	 * 
	 *
	 */
	public static int updateCab(int cabNo, int driverId, int route_no)
			throws IOException {
		// System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);

			pps.setInt(1, cabNo);
			pps.setInt(2, driverId);
			pps.setInt(3, route_no);

			int rowUpdated = pps.executeUpdate();
			System.out.println(rowUpdated);
			if (rowUpdated == 1)
				return 1;

		}// try
		catch (SQLException e) {
			e.printStackTrace();
		}// catch
		return 0;
	}// update cab details

	/**
	 * 
	 * @author User
	 * @param cab_no
	 *            ,driver_id,route_no
	 * @method deleteCabDetails
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */
	public static int deleteCab(int no) throws IOException, SQLException {
		conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(deleteQuery);
			statement.setInt(1, no);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 1)
				return 1;

		} // try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return 0;
	}// delete cab method

}// class

