package com.spring.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ElectionEntity;
import com.spring.entity.UserEntity;
import com.spring.entity.VoterEntity;

public interface VoterRepository extends JpaRepository<VoterEntity, String>{

	



}
