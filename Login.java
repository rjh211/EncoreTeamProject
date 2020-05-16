package EncoreTeamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	String id = null;
	String pw = null;
	
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String sql = null;
	
	Connection conn = null;
	
	public int checkIDPW(Scanner sc) {
		System.out.print("id : ");
		id = sc.next();
		System.out.print("pw : ");
		pw = sc.next();
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "charles", "7276"); // 연결할 정보를 가지고있는 드라이버매니저를 던진다
            stmt = conn.createStatement();
 
            sql = "select * from member where id='" + id + "'";
            rs = stmt.executeQuery(sql); // 읽어오는거라 다르다 비교해    //리턴타입이 ResultSet
 
            if (rs.next() == false || (id.isEmpty()) == true) { // id가 존재x
                result = 0;
            } else {
                sql = "select * from (select * from member where id='" + id + "')";
                rs = stmt.executeQuery(sql);
                while (rs.next() == true) {         // 다음값의
                    if (rs.getString(2).equals(pw)) { // pw와 같은지 비교
                        result = 1;         // 같으면 로그인 성공
                    } else {                // 아이디는같고 pw가 다른경우
                        result = 0;
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println("문제있음");
            ee.printStackTrace();
        }
        return result;
    }
}
