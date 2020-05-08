package EncoreTeamProject.Community;

import java.util.Scanner;

public interface ComService {
	void addCom(Scanner sc);
	
	void getByName(Scanner sc);
	
	void getByTitle(Scanner sc);
	
	void getAll();
	
	void editCom(Scanner sc);
	
	void delCom(Scanner sc);
	
	void selectNum(Scanner sc);
	
}
