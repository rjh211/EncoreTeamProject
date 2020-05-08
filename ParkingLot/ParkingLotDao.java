package EncoreTeamProject.ParkingLot;

public interface ParkingLotDao {
	public void Insert(ParkingLotVO pvo);				//주차장 data insert
	public void Delete(int seq);				//주차장 data delete
	public ParkingLotVO Select(int seq);		//주차장 data select
	public ParkingLotVO SelectAll();		//주차장 data select
	public void Update(ParkingLotVO pvo);				//주차장 data update
}
