package com.spring.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.ElectionEntity;


@Repository
public interface AdminRepository extends JpaRepository<ElectionEntity, String> {

	List<ElectionEntity> findByElectiondate(LocalDate electionDate);

	ElectionEntity findByElectionid(String electionid); //

	

	
}
