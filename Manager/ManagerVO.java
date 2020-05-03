package ParkingService.Manager;

public class ManagerVO {
	String id, pw;		//°ü¸®ÀÎ id pw
	public ManagerVO(){}
	public ManagerVO(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "ManagerVO [id=" + id + ", pw=" + pw + "]";
	}
	
}
