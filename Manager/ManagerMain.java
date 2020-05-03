package EncoreTeamProject.Manager;

import java.util.Scanner;

public class ManagerMain {
	//ManagerService mService = new ManagerService();	
	//ManagerDao mDao = new ManagerDao();				//인터페이스 생성자 구축
	public ManagerMain(){}
	public void Run(Scanner sc){
		System.out.println("Id, Pw를 입력해주세요");
		int id = sc.nextInt();
		String pw = sc.next();
		//if(id == mDao.getId())						//로그인 기능 if, while문
		//로그인 성공시 기능 구현	//결제 table의 목록을 불러와서 처리(입주민 정보 관리, 자동차 정보 관리...)
	}
}
