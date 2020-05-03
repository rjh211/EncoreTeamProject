package EncoreTeamProject.Manager;

import java.util.ArrayList;

public interface ManagerDao {
	public void Insert();						//db data insert
	public void Delete();						//db data delete
	public ManagerVO Select();					//db data select
	public ArrayList<ManagerVO> SelectAll();
	public void Update();						//db data update
}
