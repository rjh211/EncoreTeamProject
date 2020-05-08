package EncoreTeamProject.Car;

import java.util.Scanner;

public class CarTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CarService cService = new CarServiceImpl();
		int select = 10;
		do{
			System.out.println("1.차 입력 10.종료");
			select = sc.nextInt();
			switch(select){
			case 1:
				cService.InsertCarInfrom(sc);
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
