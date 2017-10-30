package com.transport.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.transport.db.DBConnection;
import com.transport.model.User;

public class UserDao {

	private static Logger logger = Logger.getLogger(UserDao.class);
	private static final String TBL_NAME = "[Transport].[dbo].[User]";
	private static final String COL_USER_ID = "User_id";
	private static final String COL_USER_NAME = "User_name";
	private static final String COL_USER_PASSWORD = "User_password";

	private String insertQuery = "INSERT INTO " + TBL_NAME + " values(?,?,?)";
	private String deleteQuery = "DELETE FROM " + TBL_NAME + " WHERE "
			+ COL_USER_ID + "=?";
	private String updateQuery = "UPDATE " + TBL_NAME + " SET " + COL_USER_NAME
			+ "=?," + COL_USER_PASSWORD + "=?" + " WHERE " + COL_USER_ID + "=?";
	private String searchUserbyId = "SELECT * FROM "+TBL_NAME+" WHERE "
			+ COL_USER_ID + "=?";
	private String searchUserbyName = "SELECT * FROM "+TBL_NAME+" WHERE "
			+ COL_USER_NAME + "=?";
	private String searchAllUsers = "SELECT * FROM " + TBL_NAME;

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet resultSet;

	// Method for adding user into table
	public void add(User user) throws SQLException {

		stmt = getStatement(insertQuery);

	//	stmt.setInt(1, user.getUserId());
		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getUserPassword());
		stmt.setString(3, user.getUserType());

		int check = stmt.executeUpdate();

		if (check > 0)
			logger.debug("user inserted");
		else
			logger.debug("failed to insert user");
	}

	// method for deleting student from database
	public void delete(String userId) throws SQLException {

		stmt = getStatement(deleteQuery);
		stmt.setString(1, userId);
		int check = stmt.executeUpdate();

		if (check > 0)
			logger.debug("user deleted");
		else
			logger.debug("failed to delete user");
	}

	// method for updating a student in the database
	public void update(User user) throws SQLException {

		User userInDB = new UserDao().getUser(user.getUserId());
		stmt = getStatement(updateQuery);

		if (user.getUserName() == null)
			user.setUserName(userInDB.getUserName());

		if (user.getUserPassword() == null)
			user.setUserPassword(userInDB.getUserPassword());

		stmt.setString(1, user.getUserPassword());
		stmt.setString(2, user.getUserName());
		stmt.setInt(3, user.getUserId());

		int check = stmt.executeUpdate();
		if (check > 0)
			logger.debug("user updated");
		else
			logger.debug("failed to update user");

	}

	// method for searching single user from the database using userId
	public User getUser(int i) throws SQLException {
		stmt = getStatement(searchUserbyId);
		stmt.setLong(1, i);
		resultSet = stmt.executeQuery();
		User user = new User();

		if (resultSet.next()) {
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setUserPassword(resultSet.getString(3));
		}
		return user;
	}

	// method for searching all users in the database
	public List<User> getAllUsers() throws SQLException {

		stmt = getStatement(searchAllUsers);
		resultSet = stmt.executeQuery();
		List<User> users = new ArrayList<User>();
		User user = null;
		while (resultSet.next()) {
			user = new User();
			user.setUserId(resultSet.getInt(1));
			user.setUserPassword(resultSet.getString(2));
			user.setUserName(resultSet.getString(3));
			users.add(user);
		}
		return users;
	}

	// private method for creating common statement instance
	private PreparedStatement getStatement(String query) throws SQLException {
		con = DBConnection.getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		return statement;
	}

	public User getUserbyName(String userName) throws SQLException {
		// TODO Auto-generated method stub
		stmt = getStatement(searchUserbyName);
		stmt.setString(1, userName);
		resultSet = stmt.executeQuery();
		User user = new User();

		if (resultSet.next()) {
			user.setUserId(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			user.setUserPassword(resultSet.getString(3));
			user.setUserType(resultSet.getString(4));
		}
		return user;	
	}
}
