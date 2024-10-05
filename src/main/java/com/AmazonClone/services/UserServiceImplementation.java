package com.AmazonClone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmazonClone.entities.User;
import com.AmazonClone.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository; // Injecting the UserRepository

    @Override
    public boolean usernameExists(String username) {
        // Check if a user with the specified username exists in the database
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public void addUser(User user) {
        // Save the user to the database
        userRepository.save(user);
    }

    @Override
    public boolean validateUser(String username, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(username);
        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }

	@Override
	public boolean userExists(String username, String email) {
		// TODO Auto-generated method stub
		return false;
	}
}
