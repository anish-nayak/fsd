package com.spring.json;

public class LoginResponse {

	private String result;
	private String message;
	private String sessionid;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSessionId() {
		return sessionid;
	}

	public void setSessionId(String sessionId) {
		this.sessionid = sessionId;
	}

	@Override
	public String toString() {
		return "LoginResponse [result=" + result + ", message=" + message + ", sessionid=" + sessionid + "]";
	}

}
