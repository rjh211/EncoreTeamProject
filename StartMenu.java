package EncoreTeamProject;

import java.util.Scanner;

import EncoreTeamProject.Member.ManagerMenu;
import EncoreTeamProject.Member.MemberDao;
import EncoreTeamProject.Member.MemberDaoImpl;
import EncoreTeamProject.Member.MemberMenu;
import EncoreTeamProject.Member.MemberService;
import EncoreTeamProject.Member.MemberServiceImpl;
import EncoreTeamProject.Member.MemberVO;

public class StartMenu {
	public static MemberVO mvo = null;
	public static void main(String[] args){
		MemberMenu memberMenu = new MemberMenu();
		ManagerMenu managerMenu = new ManagerMenu();
		MemberService mService = new MemberServiceImpl();
		
		boolean flag = true;
		int menu = 0;		
		Scanner sc = new Scanner(System.in);
		String str = "1.로그인 2.회원가입 3.종료";
		while(flag){
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu){
			case 1:
				if(login(sc)==1){
					if(mvo.getId().startsWith("a")){
						managerMenu.run(sc);
					}
					memberMenu.run(sc);				
				}
				break;
			case 2:
				mService.signUp(sc);
				break;
			case 3: 
				flag = false;
			}
		}
	}
 static int login(Scanner sc) {
		MemberDao mDao = new MemberDaoImpl();

		while (true) {
			System.out.print("id:");
			String loginId = sc.next();
			MemberVO v = mDao.selectByID(loginId);
			if (v == null) {
				System.out.println("잘못된 id입니다.다시입력하세요.");

			} else if (loginId.equals(v.getId())) {
				
				mvo=v;
				System.out.print("pw:");
				String pw = sc.next();
				
				if (pw.equals(v.getPw())) {
					
					if(v.getRegister()==1){
						System.out.println("로그인 성공~");						
						return 1;
					}else{
						System.out.println("관리인의 수락 필요합니다.");
						return -1;
					}
				} else {
					System.out.println("틀린 pwd입니다. 다시 입력하세요.");
				}
			}
		}

	}
	

}
