package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_application")
public class ApplicationEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "userid", length= 6)
	@Id
	private Long userid;
	
	@Column( name = "constituency", length= 20)
	private  String constituency;
	
	@Column( name = "passedstatus", length= 2)
	private int passedstatus; 
	
	@Column( name = "approvedstatus", length= 2)
	private int approvedstatus;
	
	@Column( name = "voterid", length= 8)
	private Long voterid;
	
	public ApplicationEntity() {
		super();
	}
	
	public ApplicationEntity(String constituency, int approvedStatus, Long voterId) {
		super();
		this.constituency = constituency;
		this.approvedstatus = approvedStatus;
		this.voterid = voterId;
	}

	public ApplicationEntity(Long userId, String constituency, int passedStatus, int approvedStatus, Long voterId) {
		super();
		this.userid = userId;
		this.constituency = constituency;
		this.passedstatus = passedStatus;
		this.approvedstatus = approvedStatus;
		this.voterid = voterId;
	}
	public Long getUserId() {
		return userid;
	}
	public void setUserId(Long userId) {
		this.userid = userId;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedstatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedstatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedstatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedstatus = approvedStatus;
	}
	public Long getVoterId() {
		return voterid;
	}
	public void setVoterId(Long voterId) {
		this.voterid = voterId;
	}
	@Override
	public String toString() {
		return "Application [userId=" + userid + ", constituency=" + constituency + ", passedStatus=" + passedstatus
				+ ", approvedStatus=" + approvedstatus + ", voterId=" + voterid + "]";
	}
	
}

