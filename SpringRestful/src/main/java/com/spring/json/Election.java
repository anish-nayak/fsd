package com.spring.json;

import java.time.LocalDate;

public class Election {

	private long electionid;
	private String name;
	private LocalDate electiondate;
	private String district;
	private String constituency;
	private LocalDate countingdate;

	public Election() {
		super();
	}

	public Election(long electionid, String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.electionid = electionid;
		this.name = name;
		this.electiondate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingdate = countingDate;
	}

	public long getElectionid() {
		return electionid;
	}

	public void setElectionid(long electionid) {
		this.electionid = electionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getElectionDate() {
		return electiondate;
	}

	public void setElectionDate(LocalDate electionDate) {
		this.electiondate = electionDate;
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

	public LocalDate getCountingDate() {
		return countingdate;
	}

	public void setCountingDate(LocalDate countingDate) {
		this.countingdate = countingDate;
	}

	@Override
	public String toString() {
		return "Election [electionid=" + electionid + ", name=" + name + ", electiondate=" + electiondate
				+ ", district=" + district + ", constituency=" + constituency + ", countingdate=" + countingdate + "]";
	}

}
