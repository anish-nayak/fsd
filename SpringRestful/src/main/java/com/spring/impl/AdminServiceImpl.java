package com.spring.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.CandidateEntity;
import com.spring.entity.ElectionEntity;
import com.spring.entity.PartyEntity;
import com.spring.entity.ResultEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.json.Application;
import com.spring.json.LoginResponse;
import com.spring.json.Result;
import com.spring.json.UserCredentials;
import com.spring.repository.AdminRepository;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.CandidateRepository;
import com.spring.repository.ElectionRepository;
import com.spring.repository.PartyRepository;
import com.spring.repository.ResultRepository;
import com.spring.repository.UserCredentialsRepository;

import com.spring.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	public Object addElection(ElectionEntity election, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			String id = generateRandomString(6);
			adminRepository.save(election);
			return election;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}
	@Override
	public Object addParty(PartyEntity party, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			String id = generateRandomString(6);
			
			partyRepository.save(party);
			return party;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	public Object getElectionDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<ElectionEntity> electionList = new ArrayList<>();
			adminRepository.findAll().forEach(electionList::add);
			return electionList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

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

	public List<ElectionEntity> getElectionDetails() {
		List<ElectionEntity> electionList = new ArrayList<>();
		adminRepository.findAll().forEach(electionList::add);
		return electionList;
	}

	@Override
	public Object getPartyDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<PartyEntity> partyList = new ArrayList<>();
			partyRepository.findAll().forEach(partyList::add);
			return partyList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}



	@Override
	public LoginResponse adminLogin(UserCredentials user) {
		UserCredentials newUser = new UserCredentials();
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findById(user.getUserid()).get();
		BeanUtils.copyProperties(userCredentialsEntity, newUser);
		String sessionId = null;
		LoginResponse response = new LoginResponse();
		if (newUser.getUserid() == (user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("1") && newUser.getUsertype().equals("1")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-admin");
			response.setResult("Success");
			response.setSessionId(sessionId);

		} else if (newUser.getUserid() == (user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("2") && newUser.getUsertype().equals("2")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-electoral");
			response.setResult("Success");
			response.setSessionId(sessionId);

		} else if (newUser.getUserid() == (user.getUserid()) && newUser.getPassword().equals(user.getPassword())
				&& user.getUsertype().equals("3") && newUser.getUsertype().equals("3")) {
			sessionId = generateRandomString(6);
			userCredentialsEntity.setSessionId(sessionId);
			userCredentialsEntity.setLoginStatus(1);
			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("Login Successful-voter");
			response.setResult("Success");
			response.setSessionId(sessionId);

		} else {
			response.setMessage("Login UnSuccessful");
			response.setResult("Failure");
			response.setSessionId(null);
		}
		return response;
	}

	@Override
	public LoginResponse adminLogout(String sessionId) {
		LoginResponse response = new LoginResponse();
		if (sessionId == null) {
			response.setMessage("INVALID SESSIONID");
		} else {
			UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
			userCredentialsEntity.setSessionId(null);
			userCredentialsEntity.setLoginStatus(0);

			userCredentialsRepository.save(userCredentialsEntity);
			response.setMessage("LOGGED OUT SUCCESFULLY");
		}
		return response;
	}

	@Override
	public Object addCandidate(CandidateEntity candidate, String sessionId, Long electionid) {
		Random random = new Random();
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);

		if (userCredentialsEntity != null) {
			Long id = random.nextLong();
			candidate.setCandidateId(id);
			candidateRepository.save(candidate);
			return candidate;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}

	@Override
	public Object getCandidateDetails(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);

		if (userCredentialsEntity != null) {
			List<CandidateEntity> candidateList = new ArrayList<>();
			candidateRepository.findAll().forEach(candidateList::add);
			return candidateList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}

	@Override
	public Object updateRequest(Application application, String sessionId, Long userid) {

		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);

		if (userCredentialsEntity != null) {
			ApplicationEntity app = applicationRepository.findByUserid(userid);
			if (app != null) {
				app.setVoterId(application.getVoterId());
				app.setApprovedStatus(app.getApprovedStatus());
				app.setPassedStatus(app.getPassedStatus());
				app.setConstituency(app.getConstituency());
				applicationRepository.save(app);
				return "{\"result\": \"Success\",\"message\": \"Updated Successfully.\"}";
			} else
				return "{\"result\": \"failure\",\"message\": \"Wrong User Id\"}";
		} else {

			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
		}

	}

	@Override
	public Object getRequest(String sessionId) {

		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);

		if (userCredentialsEntity != null) {

			List<ApplicationEntity> pendingList = applicationRepository.findByApprovedstatus(0);
			if (pendingList != null) {
				return pendingList;
			} else {
				return "{\"result\": \"failure\",\"message\": \"No Pending request available.\"}";
			}
		}
		return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";

	}

	@Override
	public Object candidatesByParty(String partyName, String sessionid) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionid);
		if (userCredentialsEntity != null ) {
			List<PartyEntity> partyEntity = partyRepository.findByName(partyName);
			PartyEntity party = partyEntity.get(0);
			Long id = party.getPartyid();
			List<CandidateEntity> candidateList = candidateRepository.findByPartyid(id);
			List<String> candidate = candidateList.stream().map(CandidateEntity::getName).collect(Collectors.toList());
			return candidate;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}

	}

	@Override
	public Object update(Long candidateid, Result result, String sessionId) {
		UserCredentialsEntity userCred = userCredentialsRepository.findBySessionid(sessionId);
		
		if (userCred != null) {
			ResultEntity resultent = resultRepository.findByCandidateid(candidateid);
			if (resultent != null) {
				resultent.setElectionId(result.getElectionId());
				resultent.setCandidateId(result.getCandidateId());
				resultent.setVoteCount(result.getVoteCount());
				resultent.setResultStatus(result.getResultStatus());
				resultRepository.save(resultent);
				return "{\"result\": \"success\",\"message\": \"Status updated successfully\"}";
			} else
				return "{\"result\": \"failure\",\"message\": \"Wrong candidate Id\"}";
		} else {
			return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";
		}
	}

	@Override
	public Object deletebyElectionId(Long electionId, String sessionId) {

		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<ElectionEntity> elect = electionRepository.findByElectionid(electionId);
			ElectionEntity el = elect.get(0);
			electionRepository.delete(el);
			return "{Succesfully deleted}";
		} else {
			return "{Invalid session id}";
		}
	}

	@Override
	public Object deletebyCandidateId(Long candidateid, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<CandidateEntity> candy = candidateRepository.findByCandidateid(candidateid);
			CandidateEntity can = candy.get(0);
			candidateRepository.delete(can);
			return "{Succesfully deleted}";
		} else {
			return "{invalid session id}";
		}
	}

	@Override
	public Object getAllElectionFromElectionDate(LocalDate date, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<ElectionEntity> electionDateList = adminRepository.findByElectiondate(date);
			return electionDateList;
		} else {
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setMessage("INVALID SESSION ID");
			loginResponse.setResult("unsucessfull");
			loginResponse.setSessionId(null);
			return loginResponse;
		}
	}

	@Override
	public Object updatepassword(UserCredentials usercred, String sessionId, String password) {

		UserCredentialsEntity userCredeEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredeEntity != null) {
			userCredeEntity.setPassword(password);
			userCredentialsRepository.save(userCredeEntity);
			return "{Password successfully changed}";
		}

		return "{Invalid credentials, try again}";
	}
	
	@Override
	public Object viewResult(String sessionid) {
		UserCredentialsEntity usercred=userCredentialsRepository.findBySessionid(sessionid);
		if(usercred!=null) {
			List<ResultEntity> result=resultRepository.OrderByVotecountDesc();
			return result;
		}
		return "Invalid session id";
	}

	/*
	 * public List<Candidate_Entity> getCandidatesById() { List<Candidate_Entity>
	 * candidateEntityList = new ArrayList<>();
	 * candidateRepository.findAll().forEach(candidateEntityList::add); return
	 * candidateEntityList; } public List<Results_Entity> getResultsByElectionId() {
	 * List<Results_Entity> resultEntityList = new ArrayList<>();
	 * resultRepository.findAll().forEach(resultEntityList::add); return
	 * resultEntityList;
	 */

}
