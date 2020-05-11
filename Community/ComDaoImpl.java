package EncoreTeamProject.Community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import EncoreTeamProject.DataBaseConnect;



public class ComDaoImpl implements ComDao {
    private DataBaseConnect db;
    //private Member m;
    
    
    public ComDaoImpl() {
    	db=DataBaseConnect.getInstance();
    }
	
	@Override
	public void insert(ComVo com) {
		String sql = "insert into community values(com_seq.nextval,?,?,?,?)";
		
		Connection conn = db.getConnect();
		System.out.println(Timestamp.valueOf(LocalDateTime.now()));
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(2,com.getName());
			pstmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(3,com.getTitle());
			pstmt.setString(4, com.getContents());
			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<ComVo> selectByName(String name) {
		String sql = "select * from community where id=?";
		ArrayList<ComVo> list = new ArrayList<ComVo>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new ComVo(rs.getInt(1),rs.getTimestamp(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public ComVo selectByNum(int num) {
		String sql = "select * from community where num = ?";
		
		ComVo cv = null;
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cv = new ComVo(rs.getInt(1),rs.getTimestamp(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cv;
	}

	@Override
	public ArrayList<ComVo> selectByTitle(String title) {
		String sql = "select * from community where title  like '%"+title+"%' ";
		ArrayList<ComVo> list = new ArrayList<ComVo>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new ComVo(rs.getInt(1),rs.getTimestamp(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public ArrayList<ComVo> selectAll() {
		String sql = "select * from community";
		ArrayList<ComVo> list = new ArrayList<ComVo>();
		ResultSet rs = null;
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				list.add(new ComVo(rs.getInt(1),rs.getTimestamp(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public void update(ComVo com) {
		String sql = "update community set title=?,contents=? where num=?";
		Connection conn = db.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, com.getTitle());
			pstmt.setString(2, com.getContents());
			pstmt.setInt(3, com.getNum());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int num) {
		String sql = "delete from community where num=?";
		
		Connection conn = db.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
