package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.json.Application;
import com.spring.json.Candidate;
import com.spring.json.Election;
import com.spring.json.LoginResponse;
import com.spring.json.Party;
import com.spring.json.Result;
import com.spring.json.UserCredentials;
import com.spring.service.AdminService;

@RestController
@RequestMapping("/evs")
@CrossOrigin(origins="*")
public class AdminController {

	@Autowired
	private AdminService adminService;

	private String sessionId = null;

	@PostMapping("/election")
	public Object addElectionDetails(@RequestBody Election election, ElectionEntity electionEntity, @RequestHeader(name = "sessionId") String sessionId) {
		BeanUtils.copyProperties(election, electionEntity);
		return adminService.addElection(electionEntity,sessionId);
	}
	
	
	@PostMapping("/election/{electionid}/party/{partyid}/candidate")
	public Object addCandidateDetails(@RequestBody Candidate candidate, CandidateEntity candidateEntity, @RequestHeader(name = "sessionId")
	String sessionId,@PathVariable(name="electionid") Long electionid,@PathVariable(name="partyid") Long partyid) {
		BeanUtils.copyProperties(candidate, candidateEntity);
		return adminService.addCandidate(candidateEntity,sessionId,electionid);
	}
	
	
	
	@GetMapping("/election")
	public Object getElectionDetails(@RequestHeader(name = "sessionId") String sessionId) {
		return adminService.getElectionDetails(sessionId);
	}

	
	
	@GetMapping("/candidate")
	public Object getCandidateDetails(@RequestHeader(name = "sessionId") String sessionId
			) {
		return adminService.getCandidateDetails(sessionId);
	}
	
	@PostMapping(value="/party")
	public Object  addPartyDetails(@RequestBody Party party,PartyEntity partyEntity,@RequestHeader(name="sessionId") String sessionId){
	 BeanUtils.copyProperties(party, partyEntity);
		return adminService.addParty(partyEntity,sessionId);
		
	}
@GetMapping(value="/party")
		public Object getPartyDetails(@RequestHeader(name="sessionId") String sessionId){
			return adminService.getPartyDetails(sessionId);
		}
	
		
		  @GetMapping("/election/fromDate/{date}")
		  public Object getElectionFromElectionDate(@PathVariable(value="date") @DateTimeFormat(iso = ISO.DATE) LocalDate date,@RequestHeader(name="sessionId") String sessionId) {
		  return adminService.getAllElectionFromElectionDate( date, sessionId); }
		 
	
		
	@GetMapping(value="/user/request")
	public Object getRequest(@RequestHeader(name = "sessionId") String sessionId){
		return adminService.getRequest(sessionId);
	}
	
	@PostMapping(value="/application/{userid}/update",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object updateRequest(@RequestBody Application
			application,ApplicationEntity 
			applicationEntity ,@RequestHeader(name = "sessionId") String sessionId,
			@PathVariable(name="userid") Long userid
			){
       BeanUtils.copyProperties(application,applicationEntity);
		return adminService.updateRequest(application,sessionId,userid);
	}

	
	@PostMapping("/login")
	public LoginResponse loginAdmin(@RequestBody UserCredentials userCredentials,
			UserCredentialsEntity userCredentialsEntity) {
		LoginResponse res = adminService.adminLogin(userCredentials);
		sessionId = res.getSessionId();
		return res;
	}

	@GetMapping("/logout")
	public LoginResponse logoutAdmin() {
		return adminService.adminLogout(sessionId);
	}
	
	@GetMapping(value="party/candidate/{name}")
	public Object detailsByParty(@PathVariable(name="name") String partyName,@RequestHeader(name="sessionId") String sessionId){
		return adminService.candidatesByParty(partyName,sessionId);	
	}
	
	@PutMapping(value="/election/results/approval/{candidateId}",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object resultStatus(@PathVariable(value="candidateId") Long candidateid,@RequestBody Result result,ResultEntity resultEntity,@RequestHeader(name="sessionId") String sessionId) {
        BeanUtils.copyProperties(result, resultEntity); 
		return adminService.update(candidateid,result,sessionId);
		
	}
	@DeleteMapping(value="election/delete/{electionid}")
	public Object deleteElectionById(@PathVariable(value="electionid") Long electionId,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyElectionId(electionId,sessionid);
		
	}
	
	@DeleteMapping(value="voter/delete/{candidateId}")
	public Object deleteCandidateById(@PathVariable(value="candidateid") Long candidateid,@RequestHeader(name="sessionId") String sessionid) {
		return adminService.deletebyCandidateId(candidateid,sessionid);
		
	}
	
	@PutMapping(value="/user/changePassword",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object password(@RequestBody UserCredentials usercred,UserCredentialsEntity usercredEntity,@RequestHeader(name="sessionId") String sessionId,@RequestHeader(name="new password") String newPassword) {
        BeanUtils.copyProperties(usercred, usercredEntity); 
		return adminService.updatepassword(usercred,sessionId,newPassword);
		
	}
	
	@GetMapping(value = "/check/result")
	public Object results(@RequestHeader(name="sessionId") String sessionid) {
		return adminService.viewResult(sessionid);
	}

}
