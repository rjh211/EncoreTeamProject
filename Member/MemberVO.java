package EncoreTeamProject.Member;

public class MemberVO {
	private String id, pw;	// 입주민, 매니저 공통
	private int phoneNum;
	private int register;
	
	public MemberVO() {
	}
	
	public MemberVO(String id, String pw, int phoneNum, int register) {
		this.id = id;
		this.pw = pw;
		this.phoneNum = phoneNum;
		this.register = register;
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

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getRegister() {
		return register;
	}

	public void setRegister(int register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", phoneNum=" + phoneNum + ", register=" + register + "]";
	}

	
}
