package com.example.demo.handle;

public class ErrorResponse {
	private int status;
	private String messgae;
	private Long timestamp;
	public ErrorResponse(int status, String messgae) {
		super();
		this.status = status;
		this.messgae = messgae;
		this.timestamp = System.currentTimeMillis();
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
