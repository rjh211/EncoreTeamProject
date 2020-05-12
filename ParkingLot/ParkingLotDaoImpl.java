package EncoreTeamProject.ParkingLot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import EncoreTeamProject.DataBaseConnect;


public class ParkingLotDaoImpl implements ParkingLotDao {
	private DataBaseConnect db;
	
	public ParkingLotDaoImpl(){
		db = DataBaseConnect.getInstance();
	}
	
	@Override
	public void Insert(int carNum) {
		// TODO Auto-generated method stub
		String sql = "insert into parkinglot values(parkinglotno.nextval,?,null,null,?)";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setInt(2, carNum);
			pstmt.executeUpdate();		
			System.out.println("데이터 삽입 성공");
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
	public void Delete(int seq) {
		// TODO Auto-generated method stub
		String sql = "delete from parkinglot where seqno = " + seq;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int a = pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
			if(a == 0) System.out.println("Sequance 입력 오류");
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
	public ParkingLotVO SelectByCarnumforParkingLot(int carNum) {
		// TODO Auto-generated method stub
		String sql = "select * FROM parkinglot where carnum = " + carNum +" order by seqno desc";
		ResultSet rs = null;
		Connection conn = db.getConnect();
		ParkingLotVO pvo = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pvo = new ParkingLotVO(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4) , carNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pvo;
	}

	@Override
	public ArrayList<ParkingLotVO> SelectByCarnumforHuman(int carNum) {
		// TODO Auto-generated method stub
		String sql = "* FROM parkinglot where carnum = " + carNum;
		ResultSet rs = null;
		Connection conn = db.getConnect();
		ArrayList<ParkingLotVO> pvoList = new ArrayList<ParkingLotVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(null == rs.getTimestamp(3)){
					pvoList.add(new ParkingLotVO(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), null, rs.getInt(4) , rs.getInt(5)));
				}else{					
					pvoList.add(new ParkingLotVO(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4) , rs.getInt(5)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pvoList;
	}
	
	@Override
	public ParkingLotVO SelectByseq(int seq) {
		// TODO Auto-generated method stub
		String sql = "select * from parkinglot where seqno = " + seq;
		Connection conn = db.getConnect();
		ResultSet rs = null;
		ParkingLotVO pvo = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			if(rs.next()){
				pvo = new ParkingLotVO(rs.getInt(1),rs.getTimestamp(2).toLocalDateTime(),rs.getTimestamp(3).toLocalDateTime(),rs.getInt(4),rs.getInt(5));
				
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
		
		return pvo;
	}

	@Override
	public ArrayList<ParkingLotVO> SelectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from parkinglot";
		ResultSet rs = null;
		Connection conn = db.getConnect();
		ArrayList<ParkingLotVO> pvoList = new ArrayList<ParkingLotVO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(null == rs.getTimestamp(3)){
					pvoList.add(new ParkingLotVO(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), null, rs.getInt(4) , rs.getInt(5)));
				}else{					
					pvoList.add(new ParkingLotVO(rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4) , rs.getInt(5)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pvoList;
	}

	@Override
	public void UpdateOutTime(int carNum) {
		// TODO Auto-generated method stub
		String sql = "update parkinglot set outtime = systimestamp where outtime is null and carnum = " + carNum;
		Connection conn = db.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(pstmt.executeUpdate() == 0){
				System.out.println("차량 번호 입력 오류");
			}else{				
				System.out.println("데이터 수정 성공");
			}
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
	public void UpdateAllBySeq(ParkingLotVO pvo) {
		// TODO Auto-generated method stub
		String sql = "update parkinglot set intime = ?, outtime = ?, pay = ?, carnum = ? where seqno = " + pvo.getSeq();
		Connection conn = db.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, java.sql.Timestamp.valueOf(pvo.getInputTime()));
			pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(pvo.getOutputTime()));
			pstmt.setInt(3, pvo.getPay());
			pstmt.setInt(4, pvo.getCarNumber());
			if(pstmt.executeUpdate() == 0){
				System.out.println("시퀀스 입력 오류");
			}else{				
				System.out.println("데이터 수정 성공");
			}
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
	public Date SelectInTime(int carNum) { // 차번호로 inTime 출력. Timestamp 형식을 출력가능한 형태로 변환
		// TODO Auto-generated method stub
		String sql = "select intime from parkinglot where carNum = " + carNum ;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			java.sql.Timestamp inTime = (Timestamp) new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
			System.out.println(sdf.format(inTime));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Date SelectOutTime(int carNum) { // 차번호로 outTime 출력. Timestamp 형식을 출력가능한 형태로 변환
		// TODO Auto-generated method stub
		String sql = "select outtime from parkinglot where carNum = " + carNum ;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			java.sql.Timestamp outTime = (Timestamp) new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.format(outTime));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
