package com.spring.service;

import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.User;

public interface ElectoralServices {

	Object getApprovedUser(String sessionId);

	Object generateVoterId(Application application, Long userid, String sessionId);

}
