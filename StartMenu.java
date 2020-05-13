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
		String str = "1.�α��� 2.ȸ������ 3.����";
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
				System.out.println("�߸��� id�Դϴ�.�ٽ��Է��ϼ���.");

			} else if (loginId.equals(v.getId())) {
				
				mvo=v;
				System.out.print("pw:");
				String pw = sc.next();
				
				if (pw.equals(v.getPw())) {
					
					if(v.getRegister()==1){
						System.out.println("�α��� ����~");						
						return 1;
					}else{
						System.out.println("�������� ���� �ʿ��մϴ�.");
						return -1;
					}
				} else {
					System.out.println("Ʋ�� pwd�Դϴ�. �ٽ� �Է��ϼ���.");
				}
			}
		}

	}
	

}
