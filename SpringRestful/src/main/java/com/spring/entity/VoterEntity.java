package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evs_tbl_voter")
public class VoterEntity {

@GeneratedValue
	@Id
	@Column(name = "userid")
	private Long userid;
	
	@Column(name = "password")
	private String password;

	@Column(name = "usertype")
	private String usertype;

	@Column(name = "loginstatus")
	private int loginStatus;

	@Column(name = "sessionid")
	private String sessionid;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "dateofbirth")
	private LocalDate dateofbirth;

	@Column(name = "gender")
	private String gender;

	@Column(name = "street")
	private String street;

	@Column(name = "location")
	private String location;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	public VoterEntity() {
		super();
	}
	
	public VoterEntity(Long userid, String password, String usertype, int loginStatus, String sessionId,
			String firstName, String lastName, LocalDate dateOfBirth, String gender, String street, String location,
			String city, String state) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
		this.sessionid = sessionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
	}
//	public VoterEntity(String password, String usertype, int loginStatus, String sessionId,
//			String firstName, String lastName, LocalDate dateOfBirth, String gender, String street, String location,
//			String city, String state) {
//		super();
//		//this.userid = userid;
//		this.password = password;
//		this.usertype = usertype;
//		this.loginStatus = loginStatus;
//		this.sessionId = sessionId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dateOfBirth = dateOfBirth;
//		this.gender = gender;
//		this.street = street;
//		this.location = location;
//		this.city = city;
//		this.state = state;
//	}
	

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
		return dateofbirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateofbirth = dateOfBirth;
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
		return "VoterEntity [userid=" + userid + ", password=" + password + ", usertype=" + usertype + ", loginStatus="
				+ loginStatus + ", sessionId=" + sessionid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateofbirth + ", gender=" + gender + ", street=" + street + ", location="
				+ location + ", city=" + city + ", state=" + state + "]";
	}

}
