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
	
}
