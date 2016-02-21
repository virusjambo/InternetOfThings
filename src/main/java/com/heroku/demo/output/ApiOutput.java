package com.heroku.demo.output;

import com.heroku.demo.constants.ErrorCode;

public class ApiOutput {
	private boolean success = true;
	private String errorCode;
	private String errorMessage;

	public ApiOutput() {

	}

	/**
	 * @param success
	 * @param errorCode
	 * @param errorMessage
	 */
	public ApiOutput(boolean success, String errorCode, String errorMessage) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ApiOutput(ErrorCode errorCode) {
		this(false, errorCode.getErrorCode(), errorCode.getErrorMessage());
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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

}
