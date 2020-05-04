package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_candidate")
public class CandidateEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidateid", length = 6)
	@Id
	private Long candidateid;

	@Column(name = "name")
	private String name;

	@Column(name = "electionid")
	private Long electionid;

	@Column(name = "partyid")
	private Long partyid;

	@Column(name = "district")
	private String district;

	@Column(name = "constituency")
	private String constituency;

	@Column(name = "dateofbirth")
	private LocalDate dateofbirth;

	@Column(name = "mobileno")
	private Long mobileno;

	@Column(name = "address")
	private String address;

	@Column(name = "emailid")
	private String emailid;

	public CandidateEntity() {
		super();
	}

	public CandidateEntity(String name, Long electionid, Long partyid, String district, String constituency,
			LocalDate dateOfBirth, Long mobileNo, String address, String emailId) {
		super();
		this.name = name;
		this.electionid = electionid;
		this.partyid = partyid;
		this.district = district;
		this.constituency = constituency;
		this.dateofbirth = dateOfBirth;
		this.mobileno = mobileNo;
		this.address = address;
		this.emailid = emailId;
	}

	public CandidateEntity(String name, String district, String constituency, LocalDate dateOfBirth, Long mobileNo,
			String address, String emailId) {
		super();
		this.name = name;
		this.district = district;
		this.constituency = constituency;
		this.dateofbirth = dateOfBirth;
		this.mobileno = mobileNo;
		this.address = address;
		this.emailid = emailId;
	}

	public CandidateEntity(Long candidateId, String name, Long electionid, Long partyid, String district,
			String constituency, LocalDate dateOfBirth, Long mobileNo, String address, String emailId) {
		super();
		this.candidateid = candidateId;
		this.name = name;
		this.electionid = electionid;
		this.partyid = partyid;
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

	public Long getElectionid() {
		return electionid;
	}

	public void setElectionid(Long electionid) {
		this.electionid = electionid;
	}

	public Long getPartyid() {
		return partyid;
	}

	public void setPartyid(Long partyid) {
		this.partyid = partyid;
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

	public Long getMobileNo() {
		return mobileno;
	}

	public void setMobileNo(Long mobileNo) {
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
		return "CandidateEntity [candidateId=" + candidateid + ", name=" + name + ", electionid=" + electionid
				+ ", partyid=" + partyid + ", district=" + district + ", constituency=" + constituency
				+ ", dateOfBirth=" + dateofbirth + ", mobileNo=" + mobileno + ", address=" + address + ", emailId="
				+ emailid + "]";
	}

}
