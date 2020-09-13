package com.restfultryout.bean;

public class WelcomeMessage {
	private String message;
	
	
	public WelcomeMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WelcomeMessageBean [message=" + message + "]";
	}
	
}
