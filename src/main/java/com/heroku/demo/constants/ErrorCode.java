package com.heroku.demo.constants;

public enum ErrorCode {
	INVALID_USER("0001", "Invalid User Name or Password");
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	private ErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorCode;
	private String errorMessage;

}
