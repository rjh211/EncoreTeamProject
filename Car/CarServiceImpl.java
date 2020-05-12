package EncoreTeamProject.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class CarServiceImpl implements CarService {
	private CarDao cDao;
	public CarServiceImpl(){
		cDao = new CarDaoImpl();
	}
	@Override
	public void InsertCarInform(Scanner sc) {
	
		// TODO Auto-generated method stub
		
		int number = 0;
		String carColor = "r";
		String carSize = "s";
		boolean guest = false;
		boolean isPayed = false;
		String id = "abcd";
		
		System.out.println("차번호를 입력하시오");
		number = sc.nextInt();
		System.out.println("차 색깔을 입력하시오");
		carColor = sc.next();
		System.out.println("차 크기를 입력하시오");
		carSize= sc.next();
		System.out.println("손님? true, false");
		guest = sc.nextBoolean();
		System.out.println("요급납부여부? true, false");
		isPayed = sc.nextBoolean();
		System.out.println("id 입력");
		id = sc.next();
		
		cDao.Insert(new CarVO(number, carColor, carSize, id, guest, isPayed));
		
	}
	@Override
	public void DeleteCarInform(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("차 번호를 입력하세요.");
		int number = sc.nextInt();
		cDao.Delete(number);
	}
	@Override
	public void ShowAllCarInform() {
		// TODO Auto-generated method stub
		ArrayList<CarVO> carList = cDao.SelectAll();
		for(CarVO car : carList){
			System.out.println(car);
		}
	}
	@Override
	public void ShowCarInformBynum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("차번호를 입력하세요.");
		int carNum = sc.nextInt();
		CarVO cvo = cDao.SelectByNum(carNum);
		if(cvo == null){
			System.out.println("차량 번호 입력 오류");
		} else{
			System.out.println(cvo);
		}
	}
	@Override
	public void ShowCarInformById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("id를 입력하세요");
		String id = sc.next();
		ArrayList<CarVO> carList = cDao.SelectById(id);
		for(CarVO car : carList){
			System.out.println(car);
		}
	}
	@Override
	public void UpdateCarInform(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("수정할 차번호를 입력하세요.");
		int carNum = sc.nextInt();
		CarVO cvo = cDao.SelectByNum(carNum);
		if(cvo == null){
			System.out.println("차량 번호 입력 오류");
		} else{
			System.out.println("차량 번호를 입력하세요.");
			int newNum = sc.nextInt();
			System.out.println("차량 색깔를 입력하세요.");
			cvo.setCarColor(sc.next());
			System.out.println("차량 크기를 입력하세요.");
			cvo.setCarSize(sc.next());
			System.out.println("손님 ? true, false");
			cvo.setGuest(sc.nextBoolean());
			cDao.Update(cvo, newNum);
		}
	}
	@Override
	public void OutStandingDoc(Scanner sc) {		//parkinglot에서 미결제인 차량은 입장불가 기능 추가
		// TODO Auto-generated method stub
		ArrayList<CarVO> carList = cDao.selectByOutstandingDoc();
		for(CarVO car : carList){
			System.out.println(car);
		}
		System.out.println("차번호를 입력하세요.");
		int carNum = sc.nextInt();
		for(CarVO car : carList){
			if(car.getCarNum() == carNum){
				System.out.println("-1: 보류 , 0: 반려, 1: 승인");
				int isAccept = sc.nextInt();
				car.setIsAccepted(isAccept);
				cDao.UpdateForProcessDoc(isAccept, carNum);			//전용 update생성
			}
		}
	}
}
