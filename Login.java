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
            conn = DriverManager.getConnection(url, "charles", "7276"); // ������ ������ �������ִ� ����̹��Ŵ����� ������
            stmt = conn.createStatement();
 
            sql = "select * from member where id='" + id + "'";
            rs = stmt.executeQuery(sql); // �о���°Ŷ� �ٸ��� ����    //����Ÿ���� ResultSet
 
            if (rs.next() == false || (id.isEmpty()) == true) { // id�� ����x
                result = 0;
            } else {
                sql = "select * from (select * from member where id='" + id + "')";
                rs = stmt.executeQuery(sql);
                while (rs.next() == true) {         // ��������
                    if (rs.getString(2).equals(pw)) { // pw�� ������ ��
                        result = 1;         // ������ �α��� ����
                    } else {                // ���̵�°��� pw�� �ٸ����
                        result = 0;
                    }
                }
            }
        } catch (Exception ee) {
            System.out.println("��������");
            ee.printStackTrace();
        }
        return result;
    }
}
