package com.spring.json;

public class Application {
	private Long userid;
	private  String constituency;
	private int passedstatus; 
	private int approvedstatus;
	private Long voterid;
	
	public Application() {
		super();
	}
	
	public Application(String constituency, int passedStatus, int approvedStatus, Long voterId) {
		super();
		this.constituency = constituency;
		this.passedstatus = passedStatus;
		this.approvedstatus = approvedStatus;
		this.voterid = voterId;
	}

	public Application(Long userId, String constituency, int passedStatus, int approvedStatus, Long voterId) {
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
