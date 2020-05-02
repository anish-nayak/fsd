package com.spring.service;


import java.time.LocalDate;
import java.util.List;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.json.LoginResponse;
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

	List<ApplicationEntity> getRequest(String sessionId);
	
	List<String> candidatesByParty(String partyName,String sessionid);

	Object update(String candidateid, ResultEntity result, String sessionId);

	Boolean deletebyElectionId(String electionId, String sessionId);

	Boolean deletebyCandidateId(String candidateid, String sessionId); 	

}
