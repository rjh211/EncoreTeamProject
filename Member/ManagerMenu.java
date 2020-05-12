package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Community.ComMenu;

public class ManagerMenu {
	private MemberService mService; 
	private ComMenu cMenu;
	
	public ManagerMenu() {
		this.mService = new MemberServiceImpl();
		cMenu = new ComMenu();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.접수된 외부차량임시등록 조회\n 2.외부차량임시등록\n 3.접수된 자차등록 조회\n 4.자차등록 승인\n 5.입주민 전체출력\n 6.입주민 조회\n 7.입주민 삭제\n 8.입주민 가입승인신청 목록출력\n 9.입주민 가입신청 승인\n 10.입주민 가입승인신청 삭제\n 11.커뮤니티 12.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//접수된 외부차량임시등록 전체출력
				mService.printTempCarRegisterAll();
				break;
			case 2:	
				//외부차량임시등록 승인
				mService.acceptCar(sc);
				break;
			case 3:
				//접수된 자차등록 조회
				mService.printMyCarRegisterAll();
				break;
			case 4:
				//자차등록 승인
				mService.acceptCar(sc);
				break;
			case 5:
				//입주민 전체출력
				mService.printAll();
				break;
			case 6:
				//입주민 조회(id)
				mService.printMember(sc);
				break;
			case 7:
				//입주민 삭제(id)
				mService.delMember(sc);
				break;
			case 8:	
				//입주민 가입승인신청 목록출력
				mService.printSingUpList();
				break;
			case 9:
				//입주민 가입신청 승인
				mService.acceptSignUP(sc);
				break;
			case 10:
				//입주민 가입승인신청 삭제
				mService.deleteSignUP(sc);
				break;
			case 11:
				cMenu.run(sc);
				break;
			case 12:
				flag = false;
				break;
			default:
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
}
