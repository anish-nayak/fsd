package com.spring.service;

import com.spring.entity.UserEntity;
import com.spring.json.Application;
import com.spring.json.User;

public interface ElectoralServices {


	Object generateVoterId(Application application, String userid, String sessionId);

	Object getApprovedUser(String sessionId);

}
