package EncoreTeamProject.Member;

import java.util.ArrayList;
import java.util.Scanner;

import EncoreTeamProject.Car.CarDao;
import EncoreTeamProject.Car.CarDaoImpl;
import EncoreTeamProject.Car.CarVO;
import EncoreTeamProject.ParkingLot.ParkingLotDao;
import EncoreTeamProject.ParkingLot.ParkingLotDaoImpl;
import EncoreTeamProject.ParkingLot.ParkingLotService;
import EncoreTeamProject.ParkingLot.ParkingLotServiceImpl;
import EncoreTeamProject.ParkingLot.ParkingLotVO;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao;
	private CarDao cDao;
	private ParkingLotVO pvo;
	private ParkingLotDao pDao;
	private ParkingLotService pService;
	public static MemberVO m;
	
	public MemberServiceImpl() {
		mDao = new MemberDaoImpl();
		cDao = new CarDaoImpl();
		pvo = new ParkingLotVO();
		pDao = new ParkingLotDaoImpl();
		pService = new ParkingLotServiceImpl();
	}

	public MemberServiceImpl(MemberDaoImpl memberDaoImpl) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMember(Scanner sc) {
		// TODO Auto-generated method stub
		String id = " ";
		String pw = " ";
		int phoneNum = 0;
		int register = 0;
		
		System.out.println("��ȣ���� id�� �Է��ϼ���. ��: 101�� 101ȣ => 1010101, 201�� 2501ȣ => 2012501");
		id = sc.next();
		System.out.println("pw�� �Է��ϼ���");
		pw = sc.next();
		System.out.println("��ȭ��ȣ�� �Է��ϼ���");
		phoneNum = sc.nextInt();
		
		mDao.insert(new MemberVO(id, pw, phoneNum, register));
	}

	@Override
	public void printMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("����� id�� �Է��ϼ���.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m == null) {
			System.out.println("�������� �ʴ� id�� �Է��߽��ϴ�.");
		} else {
			System.out.println(m);
		}
	}

	@Override
	public void printAll() { //���ֹθ� ���. �������� DB���� ���� ����.
		// TODO Auto-generated method stub
		ArrayList<MemberVO> memberList = mDao.selectAll();
		for (MemberVO m : memberList) {
			if (m.getId().startsWith("a")) { // ������ id�� a�� �����ϱ�� ����.
			} else {
				System.out.println(m);
			}
		}
	}
	
	@Override
	public void editPW(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("pw�� ������ id�� �Է��ϼ���.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("�Է��� id�� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("������ pw�� �Է��ϼ���.");
			String newPW = sc.next();
			mDao.updatePW(m, newPW);
		}
	}

	@Override
	public void editPhoneNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��ȭ��ȣ�� ������ id�� �Է��ϼ���.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("�Է��� id�� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("������ ��ȭ��ȣ�� �Է��ϼ���.");
			int phoneNum = sc.nextInt();
			mDao.updatePhoneNum(m, phoneNum);
		}
	}
	
	@Override
	public void editRegister(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("���Խ��ο��θ� ������ id�� �Է��ϼ���.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("�Է��� id�� �������� �ʽ��ϴ�.");
		} else {
			System.out.println("���Խ��ο��θ� �Է��ϼ���. ������ 1, �̽����� 0�� �Է��ϼ���.");
			int register = sc.nextInt();
			if(register == 1)
				mDao.updateRegister(m);
		}
	}

	@Override
	public void delMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("������ ����� id�� �Է��ϼ���.");
		String id = sc.next();
		mDao.delete(id);
	}

	@Override
	public void inOutTime(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("�������ð��� ��ȸ�� ����ȣ�� �Է��ϼ���.");
		int carNum = sc.nextInt();
		ParkingLotVO pvo = pDao.SelectByCarnumforParkingLot(carNum);
		if(pvo == null){
			System.out.println("�� ��� ����� �����ϴ�.");
			return;
		}
		System.out.println("���� �ð� : " + pvo.getInputTime());
		System.out.println("���� �ð� : " + pvo.getOutputTime());
		/*pDao.SelectInTime(carNum);
		pDao.SelectOutTime(carNum);*/
	}

	@Override
	public void printParkingFee(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��������� ��ȸ�� ����ȣ�� �Է��ϼ���.");
		
		int charge = pvo.getPay();
		System.out.println("��������� " + charge + "�� �Դϴ�.");
	}

	@Override
	public void payParkingFee(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��������� ������ ����ȣ�� �Է��ϼ���.");
		int carNum = sc.nextInt();
		pService.Settlement(sc, pDao.SelectByCarnumforParkingLot(carNum));
	}

	@Override
	public void insertTempCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("�ܺ������ӽõ���� �����մϴ�.");
		int number = 0;
		String carColor = "r";
		String carSize = "s";
		boolean guest = true;
		boolean isPayed = false;
		String id = "abcd";
		
		System.out.println("����ȣ�� �Է��Ͻÿ�");
		number = sc.nextInt();
		System.out.println("�� ������ �Է��Ͻÿ�");
		carColor = sc.next();
		System.out.println("�� ũ�⸦ �Է��Ͻÿ�");
		carSize= sc.next();
		System.out.println("id �Է�");
		id = sc.next();
		
		cDao.Insert(new CarVO(number, carColor, carSize, id, guest, isPayed));
	}

	@Override
	public void insertMyCar(Scanner sc) {
		// TODO Auto-generated method stub
		int number = 0;
		String carColor = "r";
		String carSize = "s";
		boolean guest = false;
		boolean isPayed = true;
		String id = "abcd";
		
		System.out.println("����ȣ�� �Է��Ͻÿ�");
		number = sc.nextInt();
		System.out.println("�� ������ �Է��Ͻÿ�");
		carColor = sc.next();
		System.out.println("�� ũ�⸦ �Է��Ͻÿ�");
		carSize= sc.next();
		System.out.println("id �Է�");
		id = sc.next();
		
		cDao.Insert(new CarVO(number, carColor, carSize, id, guest, isPayed));
	}
	
	@Override
	public void printSingUpList() {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> memberList = mDao.selectAll();
		for (MemberVO m : memberList) {
			if (m.getRegister() == 0) { 
				System.out.println(m);
			} 
		}
	}
	
	@Override
	public void acceptSignUP(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("���Խ��ν�û ����Ʈ �߿��� ���Խ����� id�� �Է����ּ���. id : ");
		String id = sc.next();
		MemberVO mVO = mDao.selectByID(id);
		if (mVO == null) {
			System.out.println("id�� �ٽ� Ȯ���ϰ� �Է����ּ���");
		} else if (mVO != null && mVO.getRegister() == 1) {
			System.out.println("�̹� ���Խ��ε� ���̵��Դϴ�.");
		} else {
			mVO.setRegister(1);	
			mDao.updateRegister(mVO);
		}
	}

	@Override
	public void deleteSignUP(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("���Խ��ν�û ����Ʈ �߿��� ������ id�� �Է����ּ���. id : ");
		String id = sc.next();
		MemberVO mVO = mDao.selectByID(id);
		if (mVO == null) {
			System.out.println("id�� �ٽ� Ȯ���ϰ� �Է����ּ���");
		} else if (mVO != null && mVO.getRegister() == 1) {
			System.out.println("�̹� ���Խ��ε� ���̵��Դϴ�.");
		} else {
			mDao.delete(mVO.getId());	
		}
	}

	@Override
	public void signUp(Scanner sc) {
		MemberVO m = new MemberVO();
		System.out.println("���ֹ� ��� ��û");
		while (true) {

			System.out.print("id:");
			String id = sc.next();
			if (mDao.checkId(id) == 1) {
				m.setId(id);
				break;
			} else {
				System.out.println("�̹� �ִ� id�Դϴ�.�ٽ� �Է����ּ���.");
			}
		}
		System.out.print("pwd:");
		m.setPw(sc.next());

		System.out.println("phonenum:");
		m.setPhoneNum(sc.nextInt());
		mDao.insertSignUp(m);
	}
	

	@Override
	public void printTempCarRegisterAll() {
		// TODO Auto-generated method stub
		ArrayList<CarVO> carList = mDao.SelectTempCar();
		for (CarVO m : carList) {
			System.out.println(m);
		}
	}

	@Override
	public void acceptCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("����� ���� ��ȣ�� �Է��ϼ���");
		int carnumber = sc.nextInt();
		mDao.updateCarAccept(carnumber);
	}


	@Override
	public void printMyCarRegisterAll() {
		// TODO Auto-generated method stub
		ArrayList<CarVO> carList = mDao.SelectRegisterCar();
		for (CarVO m : carList) {
			System.out.println(m);
		}
	}



}
