package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_party")
public class PartyEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="partyid")
	private Long partyid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "leader")
	private String leader;
	
	@Column(name = "symbol")
	private String symbol;

	public Long getPartyid() {
		return partyid;
	}

	public void setPartyid(Long partyid) {
		this.partyid = partyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public PartyEntity(Long partyid, String name, String leader, String symbol) {
		super();
		this.partyid = partyid;
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
	}
	

	public PartyEntity() {
		super();
	}

	public PartyEntity(String name, String leader, String symbol) {
		super();
		this.name = name;
		this.leader = leader;
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "PartyEntity [partyid=" + partyid + ", name=" + name + ", leader=" + leader + ", symbol=" + symbol + "]";
	}
	
	
	
	
	
	
	

}
