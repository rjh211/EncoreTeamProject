package EncoreTeamProject.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn {
	private static DBConn db = new DBConn();
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private DBConn() {
	} // private »ý¼ºÀÚ ½Ì±ÛÅæ

	public static DBConn getInstance() { 
		return db;
	}

	public Connection getConnect() { 
		Connection conn = null;
		try {
			Class.forName(driver); 
			conn = DriverManager.getConnection(url, "hr", "hr"); 
																	
																	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
