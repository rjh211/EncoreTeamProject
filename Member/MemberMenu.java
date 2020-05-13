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
		String str = "1.������ȸ\n  2.�������ð���ȸ\n  3.��������\n  4.�����������\n  5.�ܺ������ӽõ��\n 6.������Ͻ�û\n 7.pw����\n 8.��ȭ��ȣ����\n 9.Ŀ�´�Ƽ\n 10.����";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				//������ȸ
				cService.ShowCarInformById(sc);
				break;
			case 2:	
				//�������ð���ȸ
				mService.inOutTime(sc);
				break;
			case 3:
				//���������ȸ
				pMain.run();
				break;
			case 4:
				//�����������
				mService.payParkingFee(sc);
				break;
			case 5:
				//�ܺ������ӽõ��
				mService.insertTempCar(sc);
				break;
			case 6:
				//������Ͻ�û
				mService.insertMyCar(sc);
				break;
			case 7:
				//pw����
				mService.editPW(sc);
				break;
			case 8:
				//��ȭ��ȣ����
				mService.editPhoneNum(sc);
				break;
			case 9:
				//Ŀ�´�Ƽ
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
		String str = "1.�α��� 2.ȸ������ 3.����";
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
