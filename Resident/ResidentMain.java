package EncoreTeamProject.Resident;

import java.util.Scanner;

public class ResidentMain {
	public ResidentMain(){}
	public void Run(Scanner sc){
		//ResidentService rService = new ResidentService();		// service, dao 객체 인터페이스에서 생성자 구축
		//ResidentDao rDao = new ResidentDao();
		System.out.println("Id, Pw를 입력해주세요");
		int id = sc.nextInt();
		String pw = sc.next();
		//if(id == mDao.getId())						//로그인 기능 if, while문
		//로그인 성공시 기능 구현	//결제 table의 목록을 불러와서 처리(검색, 정보 등록 신청...)
	}
}
