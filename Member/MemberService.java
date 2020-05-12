package EncoreTeamProject.Member;

import java.util.Scanner;

public interface MemberService {

	// 사용자 등록
	public void addMember(Scanner sc);

	// 사용자 검색(ID)해서 출력
	public void printMember(Scanner sc);

	// 사용자 전체 목록 출력
	public void printAll();

	// 사용자 수정(ID 받아서 PW 수정)
	public void editPW(Scanner sc);

	// 사용자 수정(ID 받아서 전화번호 수정)
	public void editPhoneNum(Scanner sc);

	// 사용자 수정(ID 받아서 가입승인여부 수정)
	public void editRegister(Scanner sc);

	// ID 입력 받아서 삭제
	public void delMember(Scanner sc);

	// 입출차시간조회
	public void inOutTime(Scanner sc);

	// 주차요금조회
	public void printParkingFee(Scanner sc);

	// 주차요금정산
	public void payParkingFee(Scanner sc);

	// 외부차량임시등록
	public void insertTempCar(Scanner sc);

	// 자차등록신청
	public void insertMyCar(Scanner sc);

	// 입주민 가입승인신청 목록출력
	public void printSingUpList();

	// 입주민 가입신청 승인
	public void acceptSignUP(Scanner sc);

	// 입주민 가입승인신청 삭제
	public void deleteSignUP(Scanner sc);

	void signUp(Scanner sc);

	int login(Scanner sc);
	
	
	//접수된 외부차량임시등록 전체출력
	public void printTempCarRegisterAll();
	
	//외부차량임시등록승인(차량번호)
	public void acceptCar(Scanner sc);
	
	//접수된 자차등록 조회
	public void printMyCarRegisterAll();

	

}
