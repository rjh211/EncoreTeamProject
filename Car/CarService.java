package EncoreTeamProject.Car;

import java.util.Scanner;

public interface CarService {
	public void InsertCarInform(Scanner sc);
	public void DeleteCarInform(Scanner sc);
	public void ShowAllCarInform();
	public void ShowCarInformBynum(Scanner sc);
	public void ShowCarInformById(Scanner sc);
	public void UpdateCarInform(Scanner sc);
	public void OutStandingDoc(Scanner sc);
}
