package EncoreTeamProject.Community;

import java.util.Scanner;

public class ComMenu {
 
	private ComService cs;
	
	public ComMenu(){
		this.cs = new ComServiceImpl();
	}
	
	public void run(Scanner sc){
		boolean flag = true;
		String str = "1.글쓰기 2.목록보기 3.상세보기 4.글쓴이 검색 5.제목 검색 6.수정 7.삭제 8.종료";
		int menu;
		while (flag){
			System.out.println(str);
			menu = sc.nextInt();
			switch(menu){
			case 1:
				cs.addCom(sc);
				break;
			case 2:
				cs.getAll();
				break;
			case 3:
				cs.selectNum(sc);
				break;
			case 4:
				cs.getByName(sc);
				break;
			case 5:
				cs.getByTitle(sc);
				break;			
			case 6:
				cs.editCom(sc);
				break;
			case 7:
				cs.delCom(sc);
				break;
			case 8:
				flag = false;
			}
		}
	}
	
	
}
