package com.spring.json;

public class UserCredentials {

	private long userid;
	private String password;
	private String usertype;
	private int loginStatus;
	private String sessionid;

	public UserCredentials() {
		super();
	}

	public UserCredentials(long userid, String password, String usertype, int loginStatus, String sessionId) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
		this.sessionid = sessionId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getSessionId() {
		return sessionid;
	}

	public void setSessionId(String sessionId) {
		this.sessionid = sessionId;
	}

	@Override
	public String toString() {
		return "UserCredentials [userid=" + userid + ", password=" + password + ", usertype=" + usertype
				+ ", loginStatus=" + loginStatus + ", sessionId=" + sessionid + "]";
	}
	
	

	

}
