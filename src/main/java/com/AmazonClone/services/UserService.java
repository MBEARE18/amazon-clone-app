package com.AmazonClone.services;

import org.springframework.stereotype.Service;

import com.AmazonClone.entities.User;

@Service
public interface UserService {

	boolean userExists(String username, String email);

	boolean validateUser(String username, String password);

	User getUser(String username);

	void updateUser(User user);

	void addUser(User user);

	
}
