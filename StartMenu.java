package EncoreTeamProject;

import java.util.Scanner;

import EncoreTeamProject.Member.MemberDao;
import EncoreTeamProject.Member.MemberDaoImpl;
import EncoreTeamProject.Member.MemberService;
import EncoreTeamProject.Member.MemberServiceImpl;
import EncoreTeamProject.Member.Menu;

public class StartMenu {
	MemberDao mDao;
	MemberService mService;
	Menu menu;
	
	
	public StartMenu() {
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.로그인\n 2.입주민가입신청\n 3.종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				login(sc);
				break;
			case 2:
				register(sc);
				break;
			case 3:
				flag = false;
			}
		}
	}
	
	public void login(Scanner sc) {
	    String id;
	    String pw;
	    System.out.println("Log in : ");
	    System.out.println("id: ");
	    id = sc.next();
	    System.out.println("pw: ");
	    pw = sc.next();
	    
	    MemberDaoImpl mdi = new MemberDaoImpl();
	    Menu m = new Menu();
	    if (mdi.selectByID(id) != null && ((mdi.selectByID(id)).getPw()).equals(pw) && ((mdi.selectByID(id)).getRegister()==1) ) {
	    	System.out.println("You are logged in");
	    	m.run(sc);
	    } else if (mdi.selectByID(id) != null && ((mdi.selectByID(id)).getPw()).equals(pw) && ((mdi.selectByID(id)).getRegister()==0) ) {
	    	System.out.println("아직 가입이 승인 되지 않았습니다.");
	    } else if (mdi.selectByID(id) == null) {
	    	System.out.println("존재하지 않는 id입니다.");
	    } else if (mdi.selectByID(id) != null && !((mdi.selectByID(id)).getPw()).equals(pw) ) {
	    	System.out.println("pw가 틀렸습니다.");
		} else {
	    	System.out.println("다시 확인하고 id와 pw를 입력하세요.");
	    }
	    return;
	}
		
	public void register(Scanner sc) {
		MemberService mservice = new MemberServiceImpl();
		mservice.addMember(sc);
		System.out.println("입주민 가입승인신청이 완료되었습니다.");
		
	}
}
