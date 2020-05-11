package EncoreTeamProject.Community;

import java.sql.Timestamp;

public class ComVo {
	private int num;
	private String name;
	private String title;	
	private String contents;
	//LocalDateTime date;
	Timestamp date;
	
	public ComVo() {
		
	}
	

	
	public ComVo(int num,Timestamp date, String name, String title, String contents) {		
		this.num = num;
		this.name = name;
		this.title = title;
		this.contents = contents;
		this.date = date;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public Timestamp getDate() {
		return date;
	}



	public void setDate(Timestamp date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "ComVo [num=" + num +  ", title=" + title + ", name=" + name +", date=" + date 
				+ "]";
	}
	
	
	
}
