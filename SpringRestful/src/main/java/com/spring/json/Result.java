package com.spring.json;

public class Result {
	private Long serialno;
	private Long electionid;
	private Long candidateid;
	private int votecount;
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
	public int getVoteCount() {
		return votecount;
	}
	public void setVoteCount(int voteCount) {
		this.votecount = voteCount;
	}
	public int getResultStatus() {
		return resultstatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultstatus = resultStatus;
	}
	public Result() {
		super();
	}
	public Result(long serialno, Long electionId, Long candidateId, int voteCount, int resultStatus) {
		super();
		this.serialno = serialno;
		this.electionid = electionId;
		this.candidateid = candidateId;
		this.votecount = voteCount;
		this.resultstatus = resultStatus;
	}
	public Result(Long electionId, Long candidateId, int voteCount, int resultStatus) {
		super();
		this.electionid = electionId;
		this.candidateid = candidateId;
		this.votecount = voteCount;
		this.resultstatus = resultStatus;
	}
	@Override
	public String toString() {
		return "Result [serialno=" + serialno + ", electionId=" + electionid + ", candidateId=" + candidateid
				+ ", voteCount=" + votecount + ", resultStatus=" + resultstatus + "]";
	}

}
