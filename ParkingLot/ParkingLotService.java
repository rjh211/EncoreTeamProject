package EncoreTeamProject.ParkingLot;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface ParkingLotService {
	public int CalculatePayment(Scanner sc);			//요금 계산
	public int ShowEmptyPosNum(Scanner sc);				//빈자리 확인
	public DateTimeFormatter ShowParkingTime(Scanner sc);	//주차 시간 표시
	
}
