package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByUserid(Long userid);

}
