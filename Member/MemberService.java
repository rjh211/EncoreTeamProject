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

	public void CarDataAccept(Scanner sc); // 차승인

	public void OutCarDataAccept(Scanner sc); // 외부차량승인

	public void PrintAllOutCarData(); // 외부차량정보올출력

	public void PrintAllCarData(); // 내부차량 정보 올출력
	// public void PrintMydetail();

//	public void PrintOwnCarData(); // 占쌤븝옙占쏙옙 占쏙옙회 (占쌘깍옙)
//
//	public void PrintOwnOutCarData(); // 占쏙옙占쏙옙占쏙옙 占쏙옙회(占쌘깍옙)
}