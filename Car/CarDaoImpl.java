package EncoreTeamProject.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import p0429.DataBaseConnect;

public class CarDaoImpl implements CarDao {
	private DataBaseConnect db;
	public CarDaoImpl(){
		db = DataBaseConnect.getInstance();
	}
	@Override
	public void Insert(CarVO cvo) {
		// TODO Auto-generated method stub
		
		String sql = "insert into car values(?,?,?,?,?,?,?)";
		//1. db 커넥션 수립
		Connection conn = db.getConnect();
		try {
			//2. 커넥션 객체로 스테이트먼트 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3. sql문의 ? 매핑
			pstmt.setInt(1, cvo.getCarNum());
			pstmt.setString(2, cvo.getId());
			pstmt.setString(3, cvo.getCarColor());
			pstmt.setString(4, cvo.getCarSize());
			pstmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
			pstmt.setInt(6, cvo.isGuest() ? 1 : 0);
			pstmt.setInt(7, cvo.isPayed() ? 1 : 0);
			//4. 쿼리 실행
			pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
	}

	@Override
	public CarVO Select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarVO> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub

	}

}
