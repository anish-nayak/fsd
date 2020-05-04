package com.spring.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ElectionEntity;
import com.spring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {



}
