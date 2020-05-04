package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_election")
public class ElectionEntity {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "electionid")
	@Id
	private long electionid;

	@Column(name = "name")
	private String name;

	@Column(name = "electiondate")
	private LocalDate electiondate;

	@Column(name = "district")
	private String district;

	@Column(name = "constituency")
	private String constituency;

	@Column(name = "countingdate")
	private LocalDate countingdate;

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

	public ElectionEntity(long electionid, String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.electionid = electionid;
		this.name = name;
		this.electiondate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingdate = countingDate;
	}

	public ElectionEntity(String name, LocalDate electionDate, String district, String constituency,
			LocalDate countingDate) {
		super();
		this.name = name;
		this.electiondate = electionDate;
		this.district = district;
		this.constituency = constituency;
		this.countingdate = countingDate;
	}

	public ElectionEntity() {
		super();
	}

	@Override
	public String toString() {
		return "ElectionEntity [electionid=" + electionid + ", name=" + name + ", electiondate=" + electiondate
				+ ", district=" + district + ", constituency=" + constituency + ", countingdate=" + countingdate + "]";
	}
	
	
}
