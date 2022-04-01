package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	public UserEntity findByUsername(String userName);
	
}
