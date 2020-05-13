package EncoreTeamProject.ParkingLot;

import java.util.Scanner;

public class ParkingLotTestMain {
	//public static void main(String[] args) {
	public void run(){
		ParkingLotService pService = new ParkingLotServiceImpl();
		Scanner sc = new Scanner(System.in);
		int select = 10;
		do{
			System.out.println("1.복귀 2.외출 3.모든 정보 출력 4.시퀀스로 데이터 삭제 5.시퀀스로 데이터 조회 10.종료");
			select = sc.nextInt();
			switch(select){
			case 1:
				pService.InputCar(sc);
				break;
			case 2:
				pService.OutputCar(sc);
				break;
			case 3:
				pService.ShowAllInform();
				break;
			case 4:
				pService.DeleteInform(sc);
				break;
			case 5:
				pService.ShowInformBySeq(sc);
				break;
			case 10:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 번호를 입력하였습니다.");
			}
		}while(select != 10);
		
	}

}
