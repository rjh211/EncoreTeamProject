package EncoreTeamProject.Member;

import java.util.ArrayList;

import EncoreTeamProject.Car.CarVO;

public interface MemberDao {
	public void insert(MemberVO m); // 사용자 정보 입력

	public void delete(String id); // 사용자 삭제

	public MemberVO selectByID(String id); // 사용자 선택(id)

	public ArrayList<MemberVO> selectAll(); // 사용자 전체 선택

	void updatePW(MemberVO m, String newPW);

	void updatePhoneNum(MemberVO m, int phoneNum);

	void updateRegister(MemberVO m);

	void insertSignUp(MemberVO m);
	
	void updateCarAccept(int carnumber);

	int checkId(String id);

	public void GrantCar(int number);

	public ArrayList<CarVO> SelectAllInsider();

	public ArrayList<CarVO> SelectAllOutsider();
	
	public ArrayList<CarVO> SelectTempCar();

	public ArrayList<CarVO> SelectRegisterCar();
}
