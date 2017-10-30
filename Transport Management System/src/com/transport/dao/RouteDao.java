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
import com.transport.model.Route;

public class RouteDao {

	private static Connection conn = null;

	private static String addQuery = "insert into route values(?,?)";
	private static String deleteQuery = "delete from route where route_no=?";
	private static String getOneQuery = "select * from route where route_no=?";
	private static String getAllQuery = "select * from route";
	private static String updateQuery = "update route set route_name=? where route_no=?";

	private static DBConnection DBConnection;

	/**
	 * 
	 * @author User
	 * @param route_no
	 *            , route_name
	 * @method addNewRoute
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */
	public static int addroute(Route route) throws IOException, SQLException {
		conn = DBConnection.getConnection();
		try {
			PreparedStatement pps = conn.prepareStatement(addQuery);
			pps.setInt(1, route.getRouteNo());
			pps.setString(2, route.getRouteName());

			int upateCount = pps.executeUpdate(); // Execute query
			if (upateCount == 1)
				return 1;
		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return 0;
	} // add route method

	/**
	 * 
	 * @author User
	 * @param route_no, route_name
	 * @method getCommuter
	 * @return commuter
	 * @throws IOException
	 * 
	 *
	 */
	public static Route getRoute(int id) throws IOException {
		Route route = null;
		System.out.println("get Route Details");

		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(getOneQuery);
			pps.setInt(1, id);

			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int routeNo = resultSet.getInt(1);
				String routeName = resultSet.getString(2);

				route = new Route(routeNo, routeName);
				return route;
			}// while

		}// try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}// catch
		return route;
	}// get a particular details of route

	/**
	 * 
	 * @author User
	 * @param route_no, route_name
	 * @method getAllRouteDetails
	 * @return route
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */

	public static List<Route> getRouteDetails() throws IOException,
			SQLException {
		List<Route> list = new ArrayList<Route>();
		conn = DBConnection.getConnection();
		Route route = new Route();
		try {
			PreparedStatement pps = conn.prepareStatement(getAllQuery);
			ResultSet resultSet = pps.executeQuery();
			while (resultSet.next()) {
				int routeNo = resultSet.getInt(1);
				String routeName = resultSet.getString(2);

				route.setRouteNo(routeNo);

				route.setRouteName(routeName);

				Route route1 = new Route(routeNo, routeName);
				list.add(route1);
			}// while
			return list;

		}// try

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return list;
	}// get all details of route

	/**
	 * 
	 * @author User
	 * @param route_no
	 *            , route_name
	 * @method updateRoute
	 * @return Integer
	 * @throws IOException
	 * 
	 *
	 */
	public static int updateCommuter(int routeNo, String routeName)
			throws IOException {
		System.out.println(updateQuery);
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pps = conn.prepareStatement(updateQuery);

			pps.setString(1, routeName);

			int rowUpdated = pps.executeUpdate();
			System.out.println(rowUpdated);
			if (rowUpdated == 1)
				return 1;

		}// try
		catch (SQLException e) {
			e.printStackTrace();
		}// catch
		return 0;
	}// update route details

	/**
	 * 
	 * @author User
	 * @param route_no,route_name
	 * @method deleteRoute
	 * @return Integer
	 * @throws IOException
	 * @throws SQLException
	 * 
	 *
	 */
	public static int deleteCommuter(int routeNO) throws IOException,
			SQLException {
		conn = DBConnection.getConnection();
		PreparedStatement statement;
		try {

			statement = conn.prepareStatement(deleteQuery);
			statement.setInt(1, routeNO);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 1)
				return 1;

		} // try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch
		return 0;
	}// delete route method

}// class

