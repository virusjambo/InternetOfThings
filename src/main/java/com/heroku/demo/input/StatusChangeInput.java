package com.heroku.demo.input;

import com.heroku.demo.constants.Status;

public class StatusChangeInput {
	private String userId;
	private String macAddress;
	private Status toStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Status getToStatus() {
		return toStatus;
	}

	public void setToStatus(Status toStatus) {
		this.toStatus = toStatus;
	}

}
