package EncoreTeamProject.ParkingLot;

import java.util.Scanner;

public interface ParkingLotService {
	public void InputCar(Scanner sc);
	public void OutputCar(Scanner sc);
	public void ShowAllInform();
	public void ShowInformBySeq(Scanner sc);
	public void DeleteInform(Scanner sc);
	public boolean Settlement(Scanner sc, ParkingLotVO pvo);
	public void ShowParkingState();
}
