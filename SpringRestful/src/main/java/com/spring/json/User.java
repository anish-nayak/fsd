package com.spring.json;

import java.time.LocalDate;

public class User {

	private Long userid;
	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;

	public User(Long userid, String firstName, String lastName, LocalDate dateOfBirth, String gender, String street,
			String location, String city, String state) {
		super();
		this.userid = userid;
		this.firstname = firstName;
		this.lastname = lastName;
		this.dateofbirth = dateOfBirth;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
	}

	public User() {
		super();
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
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
		return "User [userid=" + userid + ", firstName=" + firstname + ", lastName=" + lastname + ", dateOfBirth="
				+ dateofbirth + ", gender=" + gender + ", street=" + street + ", location=" + location + ", city="
				+ city + ", state=" + state + "]";
	}

}
