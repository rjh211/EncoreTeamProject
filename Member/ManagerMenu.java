package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Car.CarService;
import EncoreTeamProject.Car.CarServiceImpl;
import EncoreTeamProject.Community.ComMenu;

public class ManagerMenu {
	private MemberService mService; 
	private CarService cService;
	private ComMenu cMenu;
	
	public ManagerMenu() {
		this.mService = new MemberServiceImpl();
		cService = new CarServiceImpl();
		cMenu = new ComMenu();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.접수된 외부차량임시등록 조회\n  2.외부차량임시등록\n  3.등록된 외부차량 조회\n  4.접수된 자차등록 조회\n  5.자차등록 승인\n 6.등록된 자차 조회\n 7.미결제주차요금조회\n 8.입주민 전체출력\n 9.입주민 조회\n 10.입주민 삭제\n 11.입주민 가입승인신청 목록출력\n 12.입주민 가입신청 승인\n 13.입주민 가입승인신청 삭제\n 14.커뮤니티 15.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//접수된 외부차량임시등록 전체출력
				break;
			case 2:	
				//외부차량임시등록
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
				//입주민 전체출력
				mService.printAll();
				break;
			case 9:
				//입주민 조회(id)
				mService.printMember(sc);
				break;
			case 10:
				//입주민 삭제(id)
				mService.delMember(sc);
				break;
			case 11:	
				//입주민 가입승인신청 목록출력
				mService.printSingUpList();
				break;
			case 12:
				//입주민 가입신청 승인
				mService.acceptSignUP(sc);
				break;
			case 13:
				//입주민 가입승인신청 삭제
				mService.deleteSignUP(sc);
				break;
			case 14:
				cMenu.run(sc);
				break;
			case 15:
				flag = false;
				break;
			default:
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
}
