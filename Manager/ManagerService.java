package ParkingService.Manager;

import java.util.Scanner;

public interface ManagerService {
	public void ConfirmRequest(Scanner sc);		//결제 table에서 목록 확인
	public void InsertDBData(Scanner sc);		//관리인 id, pw 등록
	public void DeleteDBData(Scanner sc);		//관리인 id pw 삭제
	public void UpdateDBDate(Scanner sc);		//관리인 id pw 수정
}
