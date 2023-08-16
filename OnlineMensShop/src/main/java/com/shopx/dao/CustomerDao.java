package com.shopx.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopx.entities.User;

public interface CustomerDao extends JpaRepository<User, Long>{
	
	Optional<User> findByEmailAndPassword(String email, String password);
}
