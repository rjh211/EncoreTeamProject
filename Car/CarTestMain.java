package EncoreTeamProject.Car;

import java.util.Scanner;

public class CarTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CarService cService = new CarServiceImpl();
		int select = 10;
		do{
			System.out.println("1.차 입력  2.삭제 3.전체 차 출력 4.차 번호로 검색 5.아이디로 검색 6.차량 정보 수정 10.종료");
			select = sc.nextInt();
			switch(select){
			case 1:
				cService.InsertCarInform(sc);
				break;
			case 2:
				cService.DeleteCarInform(sc);
				break;
			case 3:
				cService.ShowAllCarInform();
				break;
			case 4:
				cService.ShowCarInformBynum(sc);
				break;
			case 5:
				cService.ShowCarInformById(sc);
				break;
			case 6:
				cService.UpdateCarInform(sc);
				break;
			case 10:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
			}
		}while(select != 10);
	}

}
