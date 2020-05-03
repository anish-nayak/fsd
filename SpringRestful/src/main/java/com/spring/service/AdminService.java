package com.spring.service;


import java.time.LocalDate;
import java.util.List;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.json.LoginResponse;
import com.spring.json.Result;
import com.spring.json.UserCredentials;

public interface AdminService {

	Object addElection(ElectionEntity election, String sessionId);

	Object getElectionDetails(String sessionId);

	LoginResponse adminLogin(UserCredentials userCredentials);

	LoginResponse adminLogout(String sessionId);
	

	Object addParty(PartyEntity party, String sessionId);
	
	Object getPartyDetails(String sessionId);
	
	Object getAllElectionFromElectionDate(LocalDate date,String sessionId);
	

	Object getCandidateDetails(String sessionId);

	

	Object addCandidate(CandidateEntity candidate, String sessionId, String electionid);

	Object updateRequest(ApplicationEntity applicationEntity,String sessionId, String userid);

	Object getRequest(String sessionId);
	
	Object candidatesByParty(String partyName,String sessionid);

	Object update(String candidateid, Result result, String sessionId);

	Object deletebyElectionId(String electionId, String sessionId);

	Object deletebyCandidateId(String candidateid, String sessionId); 
	
	Object updatepassword(UserCredentials usercred, String sessionId,String newpassword); 

}
