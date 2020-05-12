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
		System.out.println("차량 번호를 입력하세요.");
		int carNum = sc.nextInt();
		ParkingLotVO pvo = pDao.SelectByCarnumforParkingLot(carNum);
		cvo = cDao.SelectByNum(carNum);
		if(cvo != null){						//등록된 차량과비교
			if(!cvo.isPayed()){
				if(!Settlement(sc, pvo)){
					System.out.println("입장 불가");
					return;
				} 
			}
			pDao.Insert(carNum);
			cvo.setPayed(false);				//입장시 결제여부 false로 전환
			cDao.ChangePaymentState(cvo);		//db 반영
		} else{
			System.out.println("등록되지 않은 차량입니다.");
		}
	}

	@Override
	public void OutputCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("차량 번호를 입력하세요.");
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
		System.out.println("번호를 입력하세요.");
		int seq = sc.nextInt();
		System.out.println(pDao.SelectByseq(seq));

	}

	@Override
	public void DeleteInform(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("번호를 입력하세요.");
		int seq = sc.nextInt();
		pDao.Delete(seq);
	}
	@Override
	public boolean Settlement(Scanner sc, ParkingLotVO pvo) {
		// TODO Auto-generated method stub
		Duration duration = Duration.between(pvo.outputTime, pvo.inputTime);
		int charge = Math.abs(pvo.largeCarParkingFee * (int)(duration.getSeconds()/60));					//자동차의 크기 추가
		cvo = cDao.SelectByNum(pvo.getCarNumber()); 
		if(!cvo.isPayed())			//어떤 cvo를 받는지 
			charge *= 1.2;
		
		pvo.setPay(charge);
		pDao.UpdateAllBySeq(pvo);
		
		System.out.println("결제 하시겠습니까 true, false");
		boolean pay = sc.nextBoolean();
		if(pay){
			System.out.println("결제 금액 " + charge +"원 입니다.");
			cvo = cDao.SelectByNum(pvo.getCarNumber());
			cvo.setPayed(pay);
			cDao.ChangePaymentState(cvo);
		} else{
			System.out.println("다음 입장시 1.2배 증가된 요금을 받습니다.");
			cvo.setPayed(pay);
			cDao.ChangePaymentState(cvo);
		}
		return pay;
	}

}
