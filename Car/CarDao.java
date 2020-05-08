package EncoreTeamProject.Car;

import java.util.ArrayList;

public interface CarDao {
	public void Insert(CarVO cvo);					//db data insert
	public void Delete(int carNum);					//db data delete
	public CarVO SelectByNum(int num);					//db data select
	public ArrayList<CarVO> SelectById(String id);					//db data select
	public ArrayList<CarVO> SelectAll();	
	public void Update(CarVO cvo, int newNum);					//db data update
}
