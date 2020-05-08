package EncoreTeamProject.Community;

import java.util.ArrayList;

public interface ComDao {
	void insert(ComVo com);
	ArrayList<ComVo> selectByName(String name);
	ComVo selectByNum(int num);
	ArrayList<ComVo> selectByTitle(String title);
	ArrayList<ComVo> selectAll();
	void update(ComVo com);
	void delete(int num);
}
