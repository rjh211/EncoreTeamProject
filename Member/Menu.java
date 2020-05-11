package EncoreTeamProject.Member;

import java.util.Scanner;

import EncoreTeamProject.Community.ComDaoImpl;
import EncoreTeamProject.Community.ComMenu;
import EncoreTeamProject.Community.ComService;
import EncoreTeamProject.Community.ComServiceImpl;
import EncoreTeamProject.Manager.ManagerMenu;
import EncoreTeamProject.Manager.ManagerService;

public class Menu {
	private MemberMenu menu1;
	private ManagerMenu menu2;
	private ComMenu menu3;
	private MemberService mservice;
	private ManagerService mgservice;
	private ComService cservice;
	
	public Menu() {
		mservice = new MemberServiceImpl(new MemberDaoImpl());
		mgservice = new ManagerSerivceImpl(new ManagerDaoImpl());
		cservice = new ComServiceImpl(new ComDaoImpl());
		menu1 = new MemberMenu(mservice);
		menu2 = new ManagerMenu(mgservice);
		menu3 = new ComMenu(cservice); 
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		String str = "1.입주민 메뉴\n 2.관리인 메뉴\n 3.커뮤니티\n 종료";
		while (flag) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				menu1.run(sc);
				break;
			case 2:
				menu2.run(sc);
				break;
			case 3:
				menu3.run(sc);
				break;
			case 4:
				flag = false;
			}
		}
	}
}
