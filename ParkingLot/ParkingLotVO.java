package EncoreTeamProject.ParkingLot;

import java.time.LocalDateTime;

public class ParkingLotVO {
	public ParkingLotVO(){}
	public ParkingLotVO(int seq, LocalDateTime inputTime, LocalDateTime outputTime, int pay, int carNumber){
		this.seq = seq;
		this.inputTime = inputTime;
		this.outputTime = outputTime;
		this.pay = pay;
		this.carNumber = carNumber;
	}
	
	final int smallCarParkingFee = 500;		//소형차 요금
	final int middleCarParkingFee = 700;	//중형차 요금
	final int largeCarParkingFee = 1000;	//대형차 요금
	
	LocalDateTime inputTime, outputTime;
	int seq, pay, carNumber;
	public int getSeq(){
		return this.seq;
	}
	public void setSeq(int seq){
		this.seq = seq;
	}
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
