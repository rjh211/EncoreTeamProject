package EncoreTeamProject.Member;

import java.util.Scanner;

public class MemberMenu {
	private MemberService mservice; // 관리인 서비스
	
	public MemberMenu(MemberService mservice) {
		this.mservice = mservice;
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.자차조회\n  2.입출차시간조회\n  3.주차요금조회\n  4.주차요금정산\n  5.외부차량임시등록\n 6.자차등록신청\n 7.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//자차조회
				break;
			case 2:	
				//입출차시간조회
				break;
			case 3:
				//주차요금조회
				break;
			case 4:
				//주차요금정산
				break;
			case 5:
				//외부차량임시등록
				break;
			case 6:
				//자차등록신청
				break;
			case 7:
				flag = false;
			}
		}
	}
}
