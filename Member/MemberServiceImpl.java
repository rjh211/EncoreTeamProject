package EncoreTeamProject.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao;
	
	public MemberServiceImpl() {
		mDao = new MemberDaoImpl();
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
		
		System.out.println("동호수로 id를 입력하세요. 예: 101동 101호 => 1010101, 201동 2501호 => 2012501");
		id = sc.next();
		System.out.println("pw를 입력하세요");
		pw = sc.next();
		System.out.println("전화번호를 입력하세요");
		phoneNum = sc.nextInt();
		
		mDao.insert(new MemberVO(id, pw, phoneNum, register));
	}

	@Override
	public void printMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("멤버의 id를 입력하세요.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m == null) {
			System.out.println("존재하지 않는 id를 입력했습니다.");
		} else {
			System.out.println(m);
		}
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> memberList = mDao.selectAll();
		for (MemberVO m : memberList) {
			System.out.println(m);
		}
	}

	@Override
	public void editPW(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("pw를 수정할 id를 입력하세요.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("입력한 id가 존재하지 않습니다.");
		} else {
			System.out.println("수정할 pw를 입력하세요.");
			String newPW = sc.next();
			mDao.updatePW(m, newPW);
		}
	}

	@Override
	public void editPhoneNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("전화번호를 수정할 id를 입력하세요.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("입력한 id가 존재하지 않습니다.");
		} else {
			System.out.println("수정할 전화번호를 입력하세요.");
			int phoneNum = sc.nextInt();
			mDao.updatePhoneNum(m, phoneNum);
		}
	}
	
	@Override
	public void editRegister(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("가입승인여부를 수정할 id를 입력하세요.");
		String id = sc.next();
		MemberVO m = mDao.selectByID(id);
		if (m==null) {
			System.out.println("입력한 id가 존재하지 않습니다.");
		} else {
			System.out.println("가입승인여부를 입력하세요. 승인은 1, 미승인은 0을 입력하세요.");
			int register = sc.nextInt();
			mDao.updateRegister(m, register);
		}
	}

	@Override
	public void delMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("삭제할 멤버의 id를 입력하세오.");
		String id = sc.next();
		mDao.delete(id);
	}

}
