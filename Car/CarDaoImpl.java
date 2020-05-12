package EncoreTeamProject.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import EncoreTeamProject.DataBaseConnect;

public class CarDaoImpl implements CarDao {
	private DataBaseConnect db;
	public CarDaoImpl(){
		db = DataBaseConnect.getInstance();
	}
	@Override
	public void Insert(CarVO cvo) {
		// TODO Auto-generated method stub
		
		String sql = "insert into car values(?,?,?,?,?,?,?,?)";
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
			pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setInt(6, cvo.isGuest() ? 1 : 0);
			pstmt.setInt(7, cvo.isPayed() ? 1 : 0);
			pstmt.setInt(8, -1);
			//4. 쿼리 실행
			pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
			System.out.println("데이터 삽입 성공");
		} catch(java.sql.SQLIntegrityConstraintViolationException e){
			System.out.println("id 중복");
		}catch (SQLException e) {
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
	public void Delete(int carNum) {
		// TODO Auto-generated method stub
		String sql = "delete from car where carNumber = "+ carNum;
		Connection conn = db.getConnect();
		try {
			//2. 커넥션 객체로 스테이트먼트 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int a = pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
			if(a == 0) System.out.println("차 번호 입력 오류");
			else System.out.println("데이터 삭제 성공");
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
	public CarVO SelectByNum(int num) {
		// TODO Auto-generated method stub
		String sql = "select * from car where carnumber = "+num;
		ResultSet rs = null;
		Connection conn = db.getConnect();
		CarVO cvo = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cvo = new CarVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(6) == 1 ? true: false,rs.getInt(7) == 1 ? true: false);
				cvo.setCarEnrollDate(rs.getTimestamp(5).toLocalDateTime());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cvo;
	}
	
	@Override
	public ArrayList<CarVO> SelectById(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from car where id = '" + id+"'";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	//rs.next() 검색 결과에서 줄 이동
				int num = rs.getInt(1);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true: false;
				boolean isPayed = rs.getInt(7) == 1? true : false;
				CarVO cvo = new CarVO(num,carColor,carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
			}
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
		return list;
	}
	
	@Override
	public ArrayList<CarVO> SelectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from car";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn =db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	//rs.next() 검색 결과에서 줄 이동
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true: false;
				boolean isPayed = rs.getInt(7) == 1? true : false;
				CarVO cvo = new CarVO(num,carColor,carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
			}
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
		return list;
	}

	@Override
	public void Update(CarVO cvo, int newNum) {
		// TODO Auto-generated method stub
		String sql = "update car set carnumber = ?, carcolor = ?, carsize= ?, guest = ? where carnumber = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, newNum);
			pstmt.setString(2, cvo.getCarColor());
			pstmt.setString(3, cvo.getCarSize());
			pstmt.setInt(4, cvo.isGuest() ? 1 : 0);
			pstmt.setInt(5,cvo.getCarNum());
			pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
			System.out.println("수정 성공");
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
	public void ChangePaymentState(CarVO cvo) {
		// TODO Auto-generated method stub
		int payed = cvo.isPayed() ? 1 : 0;
		String sql = "update car set ispayed = " + payed +"where carnumber = " + cvo.getCarNum();
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
			System.out.println("수정 성공");
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


}
