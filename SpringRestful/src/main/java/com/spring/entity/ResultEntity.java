package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_result")
public class ResultEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "serialno")
	private long serialno;
	
	@Column(name = "electionid")
	private Long electionid;
	
	@Column(name = "candidateid")
	private Long candidateid;
	
	@Column(name = "votecount")
	private int votecount;
	
	@Column(name = "resultstatus")
	private int resultstatus;
	
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public Long getElectionId() {
		return electionid;
	}
	public void setElectionId(Long electionId) {
		this.electionid = electionId;
	}
	public Long getCandidateId() {
		return candidateid;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateid = candidateId;
	}
	public long getVoteCount() {
		return votecount;
	}
	public void setVoteCount(int voteCount) {
		this.votecount = voteCount;
	}
	public long getResultStatus() {
		return resultstatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultstatus = resultStatus;
	}
	public ResultEntity() {
		super();
	}
	public ResultEntity(long serialno, Long electionId, Long candidateId, int voteCount, int resultStatus) {
		super();
		this.serialno = serialno;
		this.electionid = electionId;
		this.candidateid = candidateId;
		this.votecount = voteCount;
		this.resultstatus = resultStatus;
	}
	public ResultEntity(Long electionId, Long candidateId, int voteCount, int resultStatus) {
		super();
		this.electionid = electionId;
		this.candidateid = candidateId;
		this.votecount = voteCount;
		this.resultstatus = resultStatus;
	}
	@Override
	public String toString() {
		return "ResultEntity [serialno=" + serialno + ", electionId=" + electionid + ", candidateId=" + candidateid
				+ ", voteCount=" + votecount + ", resultStatus=" + resultstatus + "]";
	}


}
