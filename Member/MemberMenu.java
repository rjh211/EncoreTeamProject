package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Car.CarService;
import EncoreTeamProject.Car.CarServiceImpl;
import EncoreTeamProject.Community.ComMenu;
import EncoreTeamProject.ParkingLot.ParkingLotService;
import EncoreTeamProject.ParkingLot.ParkingLotServiceImpl;
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
		String str = "1.자차조회\n  2.입출차시간조회\n  3.주차정보\n  4.주차요금정산\n  5.외부차량임시등록\n 6.자차등록신청\n 7.pw수정\n 8.전화번호수정\n 9.커뮤니티\n 10.종료";
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
				//주차요금정산
				mService.payParkingFee(sc);
				break;
			case 5:
				//외부차량임시등록
				mService.insertTempCar(sc);
				break;
			case 6:
				//자차등록신청
				mService.insertMyCar(sc);
				break;
			case 7:
				//pw수정
				mService.editPW(sc);
				break;
			case 8:
				//전화번호수정
				mService.editPhoneNum(sc);
				break;
			case 9:
				//커뮤니티
				com.run(sc);
				break;
			case 10:
				flag = false;
			}
		}
	}
/*	public void run2 (Scanner sc){
		boolean flag = true;
		int menu = 0;		
		String str = "1.로그인 2.회원가입 3.종료";
		while(flag){
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu){
			case 1:			
				if(mService.login(sc)==1){
					run(sc);				
				}
				break;
			case 2:
				mService.signUp(sc);
				break;
			case 3: 
				flag = false;
			}
		}
	}*/
}
