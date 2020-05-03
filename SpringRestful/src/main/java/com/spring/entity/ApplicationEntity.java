package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_application")
public class ApplicationEntity {
	@Column( name = "userid", length= 6)
	@Id
	private String userid;
	
	@Column( name = "constituency", length= 20)
	private  String constituency;
	
	@Column( name = "passedstatus", length= 2)
	private int passedstatus; 
	
	@Column( name = "approvedstatus", length= 2)
	private int approvedstatus;
	
	@Column( name = "voterid", length= 8)
	private String voterId;
	
	public ApplicationEntity() {
		super();
	}
	
	public ApplicationEntity(String constituency, int approvedStatus, String voterId) {
		super();
		this.constituency = constituency;
		this.approvedstatus = approvedStatus;
		this.voterId = voterId;
	}

	public ApplicationEntity(String userId, String constituency, int passedStatus, int approvedStatus, String voterId) {
		super();
		this.userid = userId;
		this.constituency = constituency;
		this.passedstatus = passedStatus;
		this.approvedstatus = approvedStatus;
		this.voterId = voterId;
	}
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userId) {
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
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	@Override
	public String toString() {
		return "Application [userId=" + userid + ", constituency=" + constituency + ", passedStatus=" + passedstatus
				+ ", approvedStatus=" + approvedstatus + ", voterId=" + voterId + "]";
	}
	
}

