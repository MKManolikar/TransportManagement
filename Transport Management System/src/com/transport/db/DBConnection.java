package com.transport.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnection {

	private static Connection con = null;
	public static Logger logger = Logger.getLogger(DBConnection.class);

	public DBConnection() {
		super();
	}

	public static Connection getConnection() {
		try {
			if (con != null) {
				if (!con.isClosed()) {
					return con;
				}
			}
//			ClassLoader classLoader = Thread.currentThread()
//					.getContextClassLoader();
//			InputStream input = classLoader
//					.getResourceAsStream("com/transport/resources/db.properties");
//			Properties property = new Properties();
//			property.load(input);
//
//			String dbDriver = property.getProperty("db.driver");
//			System.out.println(dbDriver);
//			String dbHost = property.getProperty("db.host");
//			String dbProtocol = property.getProperty("db.protocol");
//			String dbName = property.getProperty("db.dbname");
//			String dbPort = property.getProperty("db.port");
//			String dbUser = property.getProperty("db.user");
//			String dbPassword = property.getProperty("db.password");
//
//			String connectionString = dbProtocol + "://" + dbHost + ":"+ dbPort + ";database=" + dbName + ";user=" + dbUser	+ ";password=" + dbPassword;
			String connectionString = "jdbc:sqlserver://localhost:1433;database=Transport;user=Mahesh;password=password";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			logger.info("driverloaded");
			con = DriverManager.getConnection(connectionString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Connection established " + con);
		return con;
	}
}
