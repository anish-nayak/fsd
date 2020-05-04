package com.spring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.UserCredentialsEntity;

public interface UserCredentialsRepository extends JpaRepository<UserCredentialsEntity, Long> {

	
	UserCredentialsEntity findBySessionid(String sessionId);

	//Optional<UserCredentialsEntity> findById(long userid);

}
