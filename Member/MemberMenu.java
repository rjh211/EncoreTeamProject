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
		String str = "1.������ȸ\n  2.�������ð���ȸ\n  3.��������\n 4.�ܺ������ӽõ��\n 5.������Ͻ�û\n 6.pw����\n 7.��ȭ��ȣ����\n 8.Ŀ�´�Ƽ\n 10.����";
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
				//�ܺ������ӽõ��
				mService.insertTempCar(sc);
				break;
			case 5:
				//������Ͻ�û
				mService.insertMyCar(sc);
				break;
			case 6:
				//pw����
				mService.editPW(sc);
				break;
			case 7:
				//��ȭ��ȣ����
				mService.editPhoneNum(sc);
				break;
			case 8:
				//Ŀ�´�Ƽ
				com.run(sc);
				break;
			case 10:
				flag = false;
			}
		}
	}
}
