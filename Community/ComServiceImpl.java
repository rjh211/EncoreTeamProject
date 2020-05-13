package EncoreTeamProject.Community;

import java.util.ArrayList;
import java.util.Scanner;
import EncoreTeamProject.StartMenu;

public class ComServiceImpl implements ComService {
	private ComDao dao;
		
	public ComServiceImpl(){
		dao = new ComDaoImpl();
		
	}
		
	@Override
	public void addCom(Scanner sc) {
		ComVo cv = new ComVo();
		System.out.println(StartMenu.mvo.getId());
		cv.setName(StartMenu.mvo.getId());
		sc.nextLine();
		System.out.print("title:");
		cv.setTitle(sc.nextLine());		
		System.out.print("contents:");
		cv.setContents(sc.nextLine());
	
		dao.insert(cv);
	}

	@Override
	public void getByName(Scanner sc) {
		System.out.print("search name:"); 
		String name = sc.next();
		ArrayList<ComVo> list = dao.selectByName(name);
		if(list.isEmpty()){
			System.out.println("not found");
		}else{
			for(ComVo m : list){
				System.out.println(m);
			}
		}

	}
	
	@Override
	public void getByTitle(Scanner sc) {
		System.out.print("search title:"); 
		String title = sc.next();
		ArrayList<ComVo> list = dao.selectByTitle(title);
		if(list.isEmpty()){
			System.out.println("not found");
		}else{
			for(ComVo m : list){
				System.out.println(m);
			}
		}
		
	}

	@Override
	public void getAll() {
		ArrayList<ComVo> list = dao.selectAll();
		for (ComVo m : list) {
			System.out.println(m);
		}
	}

	@Override
	public void editCom(Scanner sc) {
		
		ComVo cv = new ComVo();
		System.out.print("edit num:");
		cv.setNum(sc.nextInt());
		ComVo vo = dao.selectByNum(cv.getNum());
		if(StartMenu.mvo.getId().equals(vo.getName())){
		
		System.out.print("new title:");
		sc.nextLine();
		cv.setTitle(sc.nextLine());
		System.out.print("new contents:");
		cv.setContents(sc.nextLine());
		
		dao.update(cv);
		}else{
		System.out.print("권한자가 아닙니다.");}
	}

	@Override
	public void delCom(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("delete num:");
		int num = sc.nextInt();
		ComVo vo = dao.selectByNum(num);
		String str = "a";
		if(StartMenu.mvo.getId().equals(vo.getName())||str.equals(vo.getName().substring(0, 1))){
		dao.delete(num);
		}else{
		System.out.print("권한자가 아닙니다.");}
	}

	@Override
	public void selectNum(Scanner sc) {
		System.out.print("click num:");
		int num = sc.nextInt();
		ComVo vo = dao.selectByNum(num);
		System.out.println(vo.getContents());
		
	}
}
