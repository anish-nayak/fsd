package com.spring.service;

import com.spring.json.Application;

public interface ElectoralServices {

	Object getApprovedUser(String sessionId);

	Object generateVoterId(Application application, Long userid, String sessionId);
	
	Object deleteByUserid(Long userid,String sessionId);

}
