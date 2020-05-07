package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_eo")
public class ElectoralOfficer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "electoralofficerid", length = 6)
	@Id
	private Long electoralofficerId;

	@Column(name = "constituency", length = 25)
	private String constituency;

	public ElectoralOfficer() {
		super();
	}

	public ElectoralOfficer(Long electoralofficerId, String constituency) {
		super();
		this.electoralofficerId = electoralofficerId;
		this.constituency = constituency;
	}

	public Long getElectoralofficerId() {
		return electoralofficerId;
	}

	public void setElectoralofficerId(Long electoralofficerId) {
		this.electoralofficerId = electoralofficerId;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	@Override
	public String toString() {
		return "ElectoralOfficer [electoralofficerId=" + electoralofficerId + ", constituency=" + constituency + "]";
	}

}
