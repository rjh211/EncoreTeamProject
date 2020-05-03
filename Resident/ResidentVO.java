package EncoreTeamProject.Resident;

import java.util.ArrayList;

public class ResidentVO {
	private String id, pw;
	ArrayList<Integer> carNum;
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
	public ArrayList<Integer> getCarNum() {
		return carNum;
	}
	public void setCarNum(ArrayList<Integer> carList) {
		this.carNum = carList;
	}
	@Override
	public String toString() {
		return "ResidentVO [id=" + id + ", pw=" + pw + ", carList=" + carNum + "]";
	}
	
	
}
