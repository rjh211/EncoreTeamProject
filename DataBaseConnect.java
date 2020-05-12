package EncoreTeamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect {
	private static DataBaseConnect db = new DataBaseConnect();
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private DataBaseConnect(){}
	public static DataBaseConnect getInstance(){
		return db;
	}
	public Connection getConnect(){		//db시스템에 연결
		Connection conn = null;
		try {
			Class.forName(driver);		//driver load
			conn = DriverManager.getConnection(url, "charles", "7276");	//db 서비스의 주소, 계정, 비밀번호를 이용하여 세션수립
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
