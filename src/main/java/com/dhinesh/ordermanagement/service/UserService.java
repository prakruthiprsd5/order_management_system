package com.dhinesh.ordermanagement.service;

import java.util.List;

import com.dhinesh.ordermanagement.dao.UserRepository;
import com.dhinesh.ordermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
    UserRepository ur;
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}

	public List<User> get(){
		return ur.findAll();
	}
}
