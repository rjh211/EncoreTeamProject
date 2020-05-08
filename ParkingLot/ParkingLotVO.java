package EncoreTeamProject.ParkingLot;

import java.time.LocalDateTime;

public class ParkingLotVO {
	private static ParkingLotVO parkingLot = new ParkingLotVO(); // 여러 객체를 생성하지 못하게 singleton 사용
	private ParkingLotVO(){}
	public static ParkingLotVO getInstance(){
		return parkingLot;										//주차장 객체 반환
	}

	final int smallCarParkingFee = 500;		//소형차 요금
	final int middleCarParkingFee = 700;	//중형차 요금
	final int largeCarParkingFee = 1000;	//대형차 요금
	
	LocalDateTime inputTime, outputTime;
	int pay, carNumber;
	
	public LocalDateTime getInputTime() {
		return inputTime;
	}
	public void setInputTime(LocalDateTime inputTime) {
		this.inputTime = inputTime;
	}
	public LocalDateTime getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(LocalDateTime outputTime) {
		this.outputTime = outputTime;
	}
	public int getPay() {
		return this.pay;
	}
	public void setPay(int pay){
		this.pay = pay;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	@Override
	public String toString() {
		return "ParkingLotVO [inputTime=" + inputTime + ", outputTime=" + outputTime + ", pay=" + pay + ", carNumber="
				+ carNumber + "]";
	}
	
	
}
