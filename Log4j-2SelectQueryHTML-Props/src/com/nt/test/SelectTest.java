package com.nt.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.jdbc.JDBCAppender;

public class SelectTest {
	private static final String SELCT_QUERY = "SELECT SNO,SNAME,SADD FROM STUDENT";
	private static Logger logger = Logger.getLogger(SelectTest.class);

	public static void main(String[] args) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			PropertyConfigurator.configure("com/nt/test/log4j.properties");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			logger.debug("connection establish");
			ps = con.prepareStatement(SELCT_QUERY);
			logger.debug("prepared statement");
			rs = ps.executeQuery();
			logger.debug("ResultSET PROCESSED");
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
				}
			}
		} catch (SQLException e) {
			logger.error("problem " + e.getErrorCode());
			System.out.println(e.getMessage());
		} catch (Exception e) {
			logger.error("unknown problem " + e.getMessage());
			System.out.println(e.getMessage());
		}
		logger.debug("Application ended");
	}// main
}// class