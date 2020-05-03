package EncoreTeamProject;

import java.util.Scanner;

import EncoreTeamProject.Manager.ManagerMain;
import EncoreTeamProject.Resident.ResidentMain;

public class ParkingServiceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ResidentMain rMain = null;
		ManagerMain mMain = null;
		int select = 0;
		do{
			System.out.println("1.입주민 2.관리자 3.종료");
			select = sc.nextInt();
			switch(select){
				case 1:
					System.out.println("입주민을 선택하셨습니다.");
					rMain = new ResidentMain();
					rMain.Run(sc);
					break;
				case 2:
					System.out.println("관리인을 선택하셨습니다.");
					mMain = new ManagerMain();
					mMain.Run(sc);
					break;
				case 3:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못된 번호 선택");
					
			}			
		}while(select != 3);
		sc.close();
	}

}
