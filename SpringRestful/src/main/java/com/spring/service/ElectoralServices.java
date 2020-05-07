package com.spring.service;

import com.spring.entity.ApplicationEntity;
import com.spring.entity.UserEntity;
import com.spring.entity.VoterEntity;
import com.spring.json.Application;

public interface ElectoralServices {

	Object getApprovedUser(String sessionId);

	Object generateVoterId(ApplicationEntity applicationentity, Long userid, String sessionId);
	
	Object deleteByUserid(Long userid,String sessionId);

}
