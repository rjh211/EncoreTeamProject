package EncoreTeamProject.ParkingLot;

import java.util.Scanner;

public class ParkingLotTestMain {
	//public static void main(String[] args) {
	public void run(){
		ParkingLotService pService = new ParkingLotServiceImpl();
		Scanner sc = new Scanner(System.in);
		int select = 10;
		do{
			System.out.println("1.���� 2.���� 3.��� ���� ��� 4.�������� ������ ���� 5.�������� ������ ��ȸ 10.����");
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
				System.out.println("�����մϴ�.");
				break;
			default:
				System.out.println("�߸��� ��ȣ�� �Է��Ͽ����ϴ�.");
			}
		}while(select != 10);
		
	}

}
