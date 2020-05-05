package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.ElectionEntity;
import com.spring.entity.ElectoralOfficer;

public interface ElectoralRepository extends JpaRepository<ElectoralOfficer, Long>{

}
