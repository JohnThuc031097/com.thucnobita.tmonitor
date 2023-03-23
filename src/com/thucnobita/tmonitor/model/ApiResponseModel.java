package com.thucnobita.tmonitor.model;

public class ApiResponseModel {
	private int code;
    private Object data;
    private String mess;
    private String durationTime;
    
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String timeResponse) {
		this.durationTime = timeResponse;
	}
}
