package com.fullstackpractice.basic.auth;

public class basicAuthBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public basicAuthBean(String message) {
		this.message = message;
	}
}
