package EncoreTeamProject.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import EncoreTeamProject.DataBaseConnect;
import EncoreTeamProject.Car.CarVO;

public class MemberDaoImpl implements MemberDao {
	private DataBaseConnect db;

	public MemberDaoImpl() {
		db = DataBaseConnect.getInstance();
	}

	@Override
	public void insert(MemberVO m) {
		// TODO Auto-generated method stub

		String sql = "insert into member values(?,?,?)";

		// 1. db 커넥션 수립
		Connection conn = db.getConnect();
		try {
			// 2. 커넥션 객체로 스테이트먼트 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 3. sql 매핑
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, m.getRegister());
			// 4. 쿼리 실행
			pstmt.executeUpdate(); // 쓰기 실행, executeQuere: 읽기 실행 select시 사용
			System.out.println("멤버 데이터 삽입 성공");
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("id 중복");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from member where id = " + id;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int a = pstmt.executeUpdate();
			if (a == 0) {
				System.out.println("id 입력 오류");
			} else {
				System.out.println("멤버 삭제 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public MemberVO selectByID(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from member where id = '" + id + "'  ";
		ResultSet rs = null;
		Connection conn = db.getConnect();
		MemberVO m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m = new MemberVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public ArrayList<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // rs.next() 검색 결과에서 줄 이동
				String id = rs.getString(1);
				String pw = rs.getString(2);
				int phoneNum = rs.getInt(3);
				int register = rs.getInt(4);
				MemberVO m = new MemberVO(id, pw, phoneNum, register);
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public void updatePW(MemberVO m, String newPW) {
		// TODO Auto-generated method stub
		String sql = "update member set pw = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, newPW);
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, m.getRegister());
			pstmt.executeUpdate();
			System.out.println("pw 수정 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updatePhoneNum(MemberVO m, int phoneNum) {
		// TODO Auto-generated method stub
		String sql = "update member set phoneNum = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, phoneNum);
			pstmt.executeUpdate();
			System.out.println("전화번호 수정 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateRegister(MemberVO m, int register) {
		// TODO Auto-generated method stub
		String sql = "update member set register = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());
			pstmt.setInt(4, register);
			pstmt.executeUpdate();
			System.out.println("가입승인여부 수정 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertSignUp(MemberVO m) {
		String sql = "insert into member values (?,?,?,-1)";

		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setInt(3, m.getPhoneNum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int checkId(String id) {
		String sql = "select id from member where id = ?";

		ResultSet rs = null;
		Connection conn = db.getConnect();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public void GrantCar(int number) {
		// TODO Auto-generated method stub
		String sql = "update car set isAccepted = 1 where carnumber  = ?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, number);
			pstmt.executeUpdate();
			System.out.println("승인되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<CarVO> SelectAllInsider() {
		// TODO Auto-generated method stub
				String sql = "select * from car where isAccepted = 1 AND guest = false";
				ArrayList<CarVO> list = new ArrayList<CarVO>();
				ResultSet rs = null;
				Connection conn = db.getConnect();
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) { // rs.next() 검색 결과에서 줄 이동
						int num = rs.getInt(1);
						String id = rs.getString(2);
						String carColor = rs.getString(3);
						String carSize = rs.getString(4);
						LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
						boolean guest = rs.getInt(6) == 1 ? true : false;
						boolean isPayed = rs.getInt(7) == 1 ? true : false;
						CarVO cvo = new CarVO(num, carColor, carSize, id, guest, isPayed);
						cvo.setCarEnrollDate(carEnrollDate);
						list.add(cvo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
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
	public ArrayList<CarVO> SelectAllOutsider() {
		// TODO Auto-generated method stub
				String sql = "select * from car where isAccepted = 1 AND guest = true";
				ArrayList<CarVO> list = new ArrayList<CarVO>();
				ResultSet rs = null;
				Connection conn = db.getConnect();
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) { // rs.next() 검색 결과에서 줄 이동
						int num = rs.getInt(1);
						String id = rs.getString(2);
						String carColor = rs.getString(3);
						String carSize = rs.getString(4);
						LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
						boolean guest = rs.getInt(6) == 1 ? true : false;
						boolean isPayed = rs.getInt(7) == 1 ? true : false;
						CarVO cvo = new CarVO(num, carColor, carSize, id, guest, isPayed);
						cvo.setCarEnrollDate(carEnrollDate);
						list.add(cvo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
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
	public ArrayList<CarVO> SelectTempCar() {
		// TODO Auto-generated method stub
		String sql = "select * from car where guest = 0 and isaccepted = -1";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // rs.next() 검색 결과에서 줄 이동
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true : false;
				boolean isPayed = rs.getInt(7) == 1 ? true : false;
				CarVO cvo = new CarVO(num, carColor, carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	public void updateCarAccept(int carnumber) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "update car set isaccepted = 1 where carnumber =  "+carnumber;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();		//쓰기 실행 , executeQuere => 읽기 실행 select시 사용
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<CarVO> SelectRegisterCar() {
		// TODO Auto-generated method stub
		String sql = "select * from car where guest= 1 and isaccepted = -1";
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // rs.next() 검색 결과에서 줄 이동
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String carColor = rs.getString(3);
				String carSize = rs.getString(4);
				LocalDateTime carEnrollDate = rs.getTimestamp(5).toLocalDateTime();
				boolean guest = rs.getInt(6) == 1 ? true : false;
				boolean isPayed = rs.getInt(7) == 1 ? true : false;
				CarVO cvo = new CarVO(num, carColor, carSize, id, guest, isPayed);
				cvo.setCarEnrollDate(carEnrollDate);
				list.add(cvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
