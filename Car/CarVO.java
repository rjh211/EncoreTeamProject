package EncoreTeamProject.Car;

import java.time.LocalDateTime;

public class CarVO {
	private int carNum, isAccepted;		//isAccepted : -1 :πÃ√≥∏Æ,  0: reject , 1: accept
	private String carColor, carSize, id;
	LocalDateTime carEnrollDate;
	boolean guest, isPayed;
	public CarVO(){}
	public CarVO(int carNum, String carColor, String carSize, String id, boolean guest, boolean isPayed){
		this.carNum = carNum;
		this.carColor = carColor;
		this.carSize = carSize;
		this.id = id;
		this.guest = guest;
		this.isPayed = isPayed;
	}
	public int getIsAccepted(){
		return this.isAccepted;
	}
	public void setIsAccepted(int isAccepted){
		this.isAccepted = isAccepted;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarSize() {
		return carSize;
	}
	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getCarEnrollDate() {
		return carEnrollDate;
	}
	public void setCarEnrollDate(LocalDateTime carEnrollDate) {
		this.carEnrollDate = carEnrollDate;
	}
	public boolean isGuest() {
		return guest;
	}
	public void setGuest(boolean guest) {
		this.guest = guest;
	}
	public boolean isPayed() {
		return isPayed;
	}
	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}
	@Override
	public String toString() {
		return "CarVO [carNum=" + carNum + ", carColor=" + carColor + ", carSize=" + carSize + ", id=" + id
				+ ", carEnrollDate=" + carEnrollDate + ", guest=" + guest + ", isPayed=" + isPayed + "]";
	}
	
}
