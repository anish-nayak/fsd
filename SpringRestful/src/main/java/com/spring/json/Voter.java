package com.spring.json;

import java.time.LocalDate;

public class Voter {


	private Long userid;
	private String password;
	private String usertype;
	private int loginStatus;
	private String sessionid;

	
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	
	
	public Voter() {
		super();
	}
	public Voter(Long userid, String password, String usertype, int loginStatus, String sessionId, String firstName,
			String lastName, LocalDate dateOfBirth, String gender, String street, String location, String city,
			String state) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
		this.sessionid = sessionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Voter [userid=" + userid + ", password=" + password + ", usertype=" + usertype + ", loginStatus="
				+ loginStatus + ", sessionId=" + sessionid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", street=" + street + ", location="
				+ location + ", city=" + city + ", state=" + state + "]";
	}
	

}

