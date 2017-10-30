package com.transport.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.transport.db.DBConnection;
import com.transport.model.Driver;
import com.transport.model.User;

public class DemoDao {
	private static Logger logger = Logger.getLogger(DemoDao.class);
	private static UserDao userdao = new UserDao();
	private static DriverDao driverdao = new DriverDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection con = DBConnection.getConnection();
			logger.info(con + "Connected");
			User user = userdao.getUserbyName("Mahesh");
			logger.info(user.getUserName());
			Driver driver = driverdao.getDriver(101);
			logger.info(driver.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
