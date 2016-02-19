package com.heroku.demo.input;

import com.heroku.demo.constants.Status;

public class StatusChangeInput {
	private String macAddress;
	private Status toStatus;

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
