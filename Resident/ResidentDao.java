package ParkingService.Resident;

import java.util.ArrayList;

public interface ResidentDao {
	public void Insert();						//ютаж╧н db insert
	public void Delete();						//ютаж╧н db delte
	public ResidentVO Select();					//ютаж╧н db select
	public ArrayList<ResidentVO> SelectAll();	
	public void Update();						//ютаж╧н db update
}
