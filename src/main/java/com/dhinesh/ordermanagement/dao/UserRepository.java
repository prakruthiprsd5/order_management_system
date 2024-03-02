package com.dhinesh.ordermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhinesh.ordermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
