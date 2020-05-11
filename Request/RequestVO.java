package EncoreTeamProject.Request;

import java.time.LocalDateTime;

public class RequestVO {
	int reqNo;		//set ºÒ°¡´É
	String reqType, reqId;
	boolean isComplete;
	LocalDateTime reqDate, CompDate;
	public int getReqNo() {
		return reqNo;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public LocalDateTime getReqDate() {
		return reqDate;
	}
	public void setReqDate(LocalDateTime reqDate) {
		this.reqDate = reqDate;
	}
	public LocalDateTime getCompDate() {
		return CompDate;
	}
	public void setCompDate(LocalDateTime compDate) {
		CompDate = compDate;
	}
	@Override
	public String toString() {
		return "RequestVO [reqNo=" + reqNo + ", reqType=" + reqType + ", reqId=" + reqId + ", isComplete=" + isComplete
				+ ", reqDate=" + reqDate + ", CompDate=" + CompDate + "]";
	}
	
	
}
