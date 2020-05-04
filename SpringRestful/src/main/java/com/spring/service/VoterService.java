package com.spring.service;

import java.time.LocalDate;

import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.Voter;


public interface VoterService {
	

	
	//Object statusVoter(String userid);
	
	//Object addVoterRequest(UserEntity user, String sessionId);
	
	//Object getElectionDateFromAllElections(LocalDate date,String sessionId);

	Object registerVoter(Voter voter);

	Object sendRequest(Application application, Long userid, String sessionId);
	

}
