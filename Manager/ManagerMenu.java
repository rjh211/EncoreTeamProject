package EncoreTeamProject.Manager;

import java.util.Scanner;

public class ManagerMenu { // 관리인 메뉴
	private ManagerService mgservice; // 관리인 서비스
	
	public ManagerMenu(ManagerService mgservice) {
		this.mgservice = mgservice;
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.접수된 외부차량임시등록 조회\n  2.외부차량임시등록 승인\n  3.등록된 외부차량 조회\n  4.접수된 자차등록 조회\n  5.자차등록 승인\n 6.등록된 자차 조회\n 7.미결제주차요금조회\n 8.주차가능대수 조회\n 9.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//접수된 외부차량임시등록 조회
				break;
			case 2:	
				//외부차량임시등록 승인
				break;
			case 3:
				//등록된 외부차량 조회
				break;
			case 4:
				//접수된 자차등록 조회
				break;
			case 5:
				//자차등록 승인
				break;
			case 6:
				//등록된 자차 조회
				break;
			case 7:
				//미결제주차요금조회
				break;
			case 8:
				//주차가능대수 조회
				break;
			case 9:
				flag = false;
			}
		}
	}
}
