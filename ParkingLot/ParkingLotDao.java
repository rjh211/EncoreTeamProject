package EncoreTeamProject.ParkingLot;

import java.util.ArrayList;

public interface ParkingLotDao {
	public void Insert(int carNum);				//주차장 data insert
	public void Delete(int seq);				//주차장 data delete
	public ParkingLotVO SelectByCarnumforParkingLot(int carNum);		//주차장 data select
	public ArrayList<ParkingLotVO> SelectByCarnumforHuman(int carNum);		//주차장 data select
	public ParkingLotVO SelectByseq(int seq);		//주차장 data select
	public ArrayList<ParkingLotVO> SelectAll();		//주차장 data select
	public void UpdateOutTime(int carNum);				//주차장 data update
	public void UpdateAllBySeq(ParkingLotVO pvo);				//주차장 data update
	public int ShowParkingAreaCount();
}
