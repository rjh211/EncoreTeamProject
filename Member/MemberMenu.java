package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Car.CarService;
import EncoreTeamProject.Car.CarServiceImpl;
import EncoreTeamProject.Community.ComMenu;
import EncoreTeamProject.ParkingLot.ParkingLotTestMain;

public class MemberMenu {
	private MemberService mService; 
	private CarService cService;
	private ComMenu com;
	private ParkingLotTestMain pMain;
	
	public MemberMenu() {
		this.mService = new MemberServiceImpl();
		cService = new CarServiceImpl();
		com = new ComMenu();
		pMain = new ParkingLotTestMain();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.자차조회\n  2.입출차시간조회\n  3.주차정보\n 4.외부차량임시등록\n 5.자차등록신청\n 6.pw수정\n 7.전화번호수정\n 8.커뮤니티\n 10.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//자차조회
				cService.ShowCarInformById(sc);
				break;
			case 2:	
				//입출차시간조회
				mService.inOutTime(sc);
				break;
			case 3:
				//주차요금조회
				pMain.run();
				break;
			case 4:
				//외부차량임시등록
				mService.insertTempCar(sc);
				break;
			case 5:
				//자차등록신청
				mService.insertMyCar(sc);
				break;
			case 6:
				//pw수정
				mService.editPW(sc);
				break;
			case 7:
				//전화번호수정
				mService.editPhoneNum(sc);
				break;
			case 8:
				//커뮤니티
				com.run(sc);
				break;
			case 10:
				flag = false;
			}
		}
	}
}
