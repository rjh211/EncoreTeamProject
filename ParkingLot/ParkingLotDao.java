package EncoreTeamProject.ParkingLot;

public interface ParkingLotDao {
	public void Insert();				//주차장 data insert
	public void Delete();				//주차장 data delete
	public ParkingLotVO Select();		//주차장 data select
	public void Update();				//주차장 data update
}
