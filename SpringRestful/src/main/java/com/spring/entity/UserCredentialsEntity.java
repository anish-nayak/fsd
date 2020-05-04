package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_user_credentials")
public class UserCredentialsEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "userid")
	private long userid;

	@Column(name = "password")
	private String password;

	@Column(name = "usertype")
	private String usertype;

	@Column(name = "loginstatus")
	private int loginstatus;

	@Column(name = "sessionid")
	private String sessionid;

	

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
		return loginstatus;
	}



	public void setLoginStatus(int loginStatus) {
		this.loginstatus = loginStatus;
	}



	public String getSessionId() {
		return sessionid;
	}



	public void setSessionId(String sessionId) {
		this.sessionid = sessionId;
	}



	public UserCredentialsEntity(long userid, String password, String usertype, int loginStatus, String sessionId) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginStatus;
		this.sessionid = sessionId;
	}



	public UserCredentialsEntity() {
		super();
	}




}
