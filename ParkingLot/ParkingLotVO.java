package EncoreTeamProject.ParkingLot;

import java.time.format.DateTimeFormatter;

public class ParkingLotVO {
	private static ParkingLotVO parkingLot = new ParkingLotVO(); // 여러 객체를 생성하지 못하게 singleton 사용
	private ParkingLotVO(){}
	public static ParkingLotVO getInstance(){
		return parkingLot;										//주차장 객체 반환
	}

	private final int smallCarParkingFee = 500;		//소형차 요금
	private final int middleCarParkingFee = 700;	//중형차 요금
	private final int largeCarParkingFee = 1000;	//대형차 요금
	
	DateTimeFormatter inputTime, outputTime;
	public DateTimeFormatter getInputTime() {
		return inputTime;
	}
	public void setInputTime(DateTimeFormatter inputTime) {
		this.inputTime = inputTime;
	}
	public DateTimeFormatter getOutputTime() {
		return outputTime;
	}
	public void setOutputTime(DateTimeFormatter outputTime) {
		this.outputTime = outputTime;
	}
	@Override
	public String toString() {
		return "ParkingLotVO [inputTime=" + inputTime + ", outputTime=" + outputTime + "]";
	}
	
}
