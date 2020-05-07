package com.spring.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.UserCredentialsEntity;
import com.spring.entity.UserEntity;
import com.spring.repository.ApplicationRepository;
import com.spring.repository.UserCredentialsRepository;
import com.spring.repository.UserRepository;
import com.spring.service.ElectoralServices;

@Service
public class ElectoralServiceImpl implements ElectoralServices {

	@Autowired
	private ApplicationRepository applicationrepo;

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Object getApprovedUser(String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {

			List<ApplicationEntity> pendingList = applicationrepo.findByApprovedstatus(1);
			if (pendingList != null) {
				return pendingList;
			} else {
				return "{\"result\": \"failure\",\"message\": \"No Pending request available.\"}";
			}
		}
		return "{\"result\": \"failure\",\"message\": \"Wrong Session Id\"}";

	}

	@Override
	public Object generateVoterId(ApplicationEntity applicationentity, Long userid, String sessionId) {
		Random rand = new Random();
		ApplicationEntity app = applicationrepo.findByUserid(userid);
		if (app != null) {
			Long voterid = rand.nextLong();
			applicationentity.setVoterId(voterid);
			applicationrepo.save(applicationentity);
			return applicationentity;
		} else {
			return "wrong userid";
		}
	}

	@Override
	public Object deleteByUserid(Long userid, String sessionId) {
		UserCredentialsEntity userCredentialsEntity = userCredentialsRepository.findBySessionid(sessionId);
		if (userCredentialsEntity != null) {
			List<UserEntity> user = userRepository.findByUserid(userid);
			UserEntity users = user.get(0);
			userRepository.delete(users);
			return "{Succesfully  deleted}";
		} else {
			return "{invalid sessionid}";
		}
	}

}
