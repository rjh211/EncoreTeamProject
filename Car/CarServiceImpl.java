package EncoreTeamProject.Car;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CarServiceImpl implements CarService {
	private CarDao cDao;
	public CarServiceImpl(){
		cDao = new CarDaoImpl();
	}
	@Override
	public void InsertCarInfrom(Scanner sc) {
	
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
		System.out.println("데이터 입력 성공");
		
	}

}
