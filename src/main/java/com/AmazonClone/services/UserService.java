package com.AmazonClone.services;

import org.springframework.stereotype.Service;

import com.AmazonClone.entities.User;

@Service
public interface UserService {

	boolean usernameExists(String username);

	void addUser(User user);

	boolean validateUser(String username, String password);

	boolean userExists(String username, String email);

}
