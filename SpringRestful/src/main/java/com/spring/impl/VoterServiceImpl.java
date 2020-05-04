package com.spring.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.entity.UserEntity;
import com.spring.entity.VoterEntity;
import com.spring.json.Application;
import com.spring.json.LoginResponse;
import com.spring.json.User;
import com.spring.json.UserCredentials;
import com.spring.json.Voter;
import com.spring.repository.AdminRepository;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.UserCredentialsRepository;
import com.spring.repository.UserRepository;
import com.spring.repository.VoterRepository;
import com.spring.service.VoterService;
@Service
public class VoterServiceImpl implements VoterService{
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoterRepository voterRepository;
	
	@Autowired
	 	private AdminRepository electionRepository;

	private final Random random = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder stringBuilder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			stringBuilder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return stringBuilder.toString();
	}

	@Override
	public Object registerVoter(Voter voter) {
		VoterEntity voten=new VoterEntity();
		voten.setUserid(voter.getUserid());
		voten.setFirstName(voter.getFirstName());
		voten.setLastName(voter.getLastName());
		voten.setDateOfBirth(voter.getDateOfBirth());
		voten.setGender(voter.getGender());
		voten.setLocation(voter.getLocation());
		voten.setStreet(voter.getStreet());
		voten.setCity(voter.getCity());
		voten.setState(voter.getState());
		voten.setPassword(voter.getPassword());
		voten.setLoginStatus(voter.getLoginStatus());
		voten.setUsertype(voter.getUsertype());
		voterRepository.save(voten);
		return "Voter registers success";
	}

	@Override
	public Object sendRequest(Application application, Long userid, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		
		if(userCredentialsEntity != null) {
			ApplicationEntity applicationEntity=new ApplicationEntity();
			applicationEntity=applicationRepository.findByUserid(userid);
			applicationEntity=applicationRepository.findByPassedstatus(0);
		    if(applicationEntity!=null) {
		    	ApplicationEntity appen=new ApplicationEntity();
		    	//appen.setConstituency(application.getConstituency());
		    	appen.setPassedStatus(application.getPassedStatus());
		    	applicationRepository.save(appen);
		    	return "request sent";
		    }
		}
		return null;
	}

	@Override
public Object statusVoter(String sessionid,Long userid) {

	UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionid);
	if(userCredentialsEntity != null) {
		ApplicationEntity applicatEntity=new ApplicationEntity();
		applicatEntity=applicationRepository.findByUserid(userid);
		return applicatEntity;
		}
	
			else {
			 LoginResponse loginResponse=new LoginResponse();
		 loginResponse.setMessage("INVALID SESSION ID");
			 loginResponse.setResult("unsucessfull");
			 loginResponse.setSessionId(null);
			 return loginResponse;
			}
		
	}

	@Override
	public Object viewSchedule(String sessionid) {
	LocalDate localDate = LocalDate.now();
			UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionid);
			if (userCredentialsEntity != null) {
				List<ElectionEntity> electionDateList = new ArrayList<>();
				electionRepository.findByElectiondateGreaterThanEqual(localDate).forEach(electionDateList::add);
				return electionDateList;
			} 
			else {
				LoginResponse loginResponse = new LoginResponse();
				loginResponse.setMessage("INVALID SESSION ID");
				loginResponse.setResult("unsucessfull");
				loginResponse.setSessionId(null);
				return loginResponse;
			}
	}
		
	}
	

