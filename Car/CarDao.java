package EncoreTeamProject.Car;

import java.util.ArrayList;

public interface CarDao {
	public void Insert(CarVO cvo);					//db data insert
	public void Delete();					//db data delete
	public CarVO Select();					//db data select
	public ArrayList<CarVO> SelectAll();	
	public void Update();					//db data update
}
