package EncoreTeamProject;

import java.util.Scanner;

import EncoreTeamProject.Member.ManagerMenu;
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
		Login login = new Login();
		
		boolean flag = true;
		int menu = 0;		
		Scanner sc = new Scanner(System.in);
		String str = "1.로그인 2.회원가입 3.종료";
		while(flag){
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu){
			case 1:
				if(login.checkIDPW(sc) == 1){
					if(login.id.startsWith("a")){
						managerMenu.run(sc);
					} else{						
						memberMenu.run(sc);				
					}
				}
				break;
			case 2:
				mService.signUp(sc);
				break;
			case 3: 
				flag = false;
				break;
			}
		}
	}
}
