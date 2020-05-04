package com.spring.json;

import java.time.LocalDate;

public class Candidate {
	private Long candidateid;
	private String name;
	private Long electionid;
	private Long partyid;
	private String district;
	private String constituency;
	private LocalDate dateofbirth;
	private String mobileno;
	private String address;
	private String emailid;
	
	
	public Candidate() {
		super();
	}


	public Candidate(Long candidateId, String name, Long electionId, Long partyId, String district,
			String constituency, LocalDate dateOfBirth, String mobileNo, String address, String emailId) {
		super();
		this.candidateid = candidateId;
		this.name = name;
		this.electionid = electionId;
		this.partyid = partyId;
		this.district = district;
		this.constituency = constituency;
		this.dateofbirth = dateOfBirth;
		this.mobileno = mobileNo;
		this.address = address;
		this.emailid = emailId;
	}


	public Long getCandidateId() {
		return candidateid;
	}


	public void setCandidateId(Long candidateId) {
		this.candidateid = candidateId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getElectionId() {
		return electionid;
	}


	public void setElectionId(Long electionId) {
		this.electionid = electionId;
	}


	public Long getPartyId() {
		return partyid;
	}


	public void setPartyId(Long partyId) {
		this.partyid = partyId;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getConstituency() {
		return constituency;
	}


	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}


	public LocalDate getDateOfBirth() {
		return dateofbirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateofbirth = dateOfBirth;
	}


	public String getMobileNo() {
		return mobileno;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileno = mobileNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmailId() {
		return emailid;
	}


	public void setEmailId(String emailId) {
		this.emailid = emailId;
	}


	@Override
	public String toString() {
		return "Candidate [candidateid=" + candidateid + ", name=" + name + ", electionid=" + electionid + ", partyid="
				+ partyid + ", district=" + district + ", constituency=" + constituency + ", dateofbirth=" + dateofbirth
				+ ", mobileno=" + mobileno + ", address=" + address + ", emailid=" + emailid + "]";
	}
	
}
