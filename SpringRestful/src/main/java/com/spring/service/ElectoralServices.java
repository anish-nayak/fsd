package com.spring.service;

import com.spring.entity.ApplicationEntity;

public interface ElectoralServices {

	Object getApprovedUser(String sessionId);

	Object generateVoterId(ApplicationEntity applicationentity, Long userid, String sessionId);

	Object deleteByUserid(Long userid, String sessionId);

}
