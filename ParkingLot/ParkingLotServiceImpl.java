package EncoreTeamProject.ParkingLot;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import EncoreTeamProject.Car.CarDao;
import EncoreTeamProject.Car.CarDaoImpl;
import EncoreTeamProject.Car.CarVO;

public class ParkingLotServiceImpl implements ParkingLotService {
	private ParkingLotDao pDao;
	private CarVO cvo;
	CarDao cDao;
	public ParkingLotServiceImpl(){
		pDao = new ParkingLotDaoImpl();
		cDao = new CarDaoImpl();
	}
	@Override
	public void InputCar(Scanner sc) {
		System.out.println("���� ��ȣ�� �Է��ϼ���.");
		int carNum = sc.nextInt();
		ParkingLotVO pvo = pDao.SelectByCarnumforParkingLot(carNum);
		cvo = cDao.SelectByNum(carNum);
		if(cvo != null){						//��ϵ� ��������
			if(!cvo.isPayed()){
				if(!Settlement(sc, pvo)){
					System.out.println("���� �Ұ�");
					return;
				} 
			} 
			pDao.Insert(carNum);
			cvo.setPayed(false);				//����� �������� false�� ��ȯ
			cDao.ChangePaymentState(cvo);		//db �ݿ�
		} else{
			System.out.println("��ϵ��� ���� �����Դϴ�.");
		}
	}

	@Override
	public void OutputCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("���� ��ȣ�� �Է��ϼ���.");
		int carNum = sc.nextInt();
		pDao.UpdateOutTime(carNum);
		ParkingLotVO pvo = pDao.SelectByCarnumforParkingLot(carNum);
		Settlement(sc,pvo);
	}

	@Override
	public void ShowAllInform() {
		// TODO Auto-generated method stub
		ArrayList<ParkingLotVO> list = pDao.SelectAll();
		for(ParkingLotVO element : list){
			System.out.println(element);
		}
	}

	@Override
	public void ShowInformBySeq(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��ȣ�� �Է��ϼ���.");
		int seq = sc.nextInt();
		System.out.println(pDao.SelectByseq(seq));

	}

	@Override
	public void DeleteInform(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��ȣ�� �Է��ϼ���.");
		int seq = sc.nextInt();
		pDao.Delete(seq);
	}
	@Override
	public boolean Settlement(Scanner sc, ParkingLotVO pvo) {
		// TODO Auto-generated method stub
		Duration duration = Duration.between(pvo.outputTime, pvo.inputTime);
		int charge = Math.abs(pvo.largeCarParkingFee * (int)(duration.getSeconds()/60));					//�ڵ����� ũ�� �߰�
		cvo = cDao.SelectByNum(pvo.getCarNumber()); 
		if(!cvo.isPayed())			 
			charge *= 1.2;
		
		pvo.setPay(charge);
		pDao.UpdateAllBySeq(pvo);
		
		System.out.println("���� �Ͻðڽ��ϱ� true, false");
		boolean pay = sc.nextBoolean();
		if(pay){
			System.out.println("���� �ݾ� " + charge +"�� �Դϴ�.");
			cvo = cDao.SelectByNum(pvo.getCarNumber());
			cvo.setPayed(pay);
			cDao.ChangePaymentState(cvo);
		} else{
			System.out.println("���� ����� 1.2�� ������ ����� �޽��ϴ�.");
			cvo.setPayed(pay);
			cDao.ChangePaymentState(cvo);
		}
		return pay;
	}

}
