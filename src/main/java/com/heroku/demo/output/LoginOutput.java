package com.heroku.demo.output;

import com.heroku.demo.constants.ErrorCode;

public class LoginOutput extends ApiOutput {
	/**
	 * @param userId
	 */
	public LoginOutput(long userId) {
		super();
		this.userId = userId;
	}
	public LoginOutput(ErrorCode errorCode) {
		super(errorCode);
	}
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
}
