package EncoreTeamProject.Resident;

import java.util.ArrayList;
import java.util.Scanner;

import EncoreTeamProject.Car.CarVO;

public interface ResidentService {
	public ArrayList<CarVO> SearchMyCar(Scanner sc);		//내차 검색
	public ResidentVO SearchMyInform(Scanner sc);		//정보 검색
	public void InformRequest(Scanner sc);				//내정보 등록요청
	public void CarRequest(Scanner sc);					//내차 등록 요청
	public void RequestGuest(Scanner sc);				//손님 방문 요청
}
