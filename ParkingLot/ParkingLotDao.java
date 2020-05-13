package EncoreTeamProject.ParkingLot;

import java.util.ArrayList;

public interface ParkingLotDao {
	public void Insert(int carNum);				//������ data insert
	public void Delete(int seq);				//������ data delete
	public ParkingLotVO SelectByCarnumforParkingLot(int carNum);		//������ data select
	public ArrayList<ParkingLotVO> SelectByCarnumforHuman(int carNum);		//������ data select
	public ParkingLotVO SelectByseq(int seq);		//������ data select
	public ArrayList<ParkingLotVO> SelectAll();		//������ data select
	public void UpdateOutTime(int carNum);				//������ data update
	public void UpdateAllBySeq(ParkingLotVO pvo);				//������ data update
	
}
