package com.AmazonClone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AmazonClone.entities.User;
import com.AmazonClone.services.UserService;


import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/signUp")
	 public String addUser(@ModelAttribute User user, Model model) {
        // Validate that fields are not blank
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();
        
        if (username == null || username.isEmpty() || 
            email == null || email.isEmpty() || 
            password == null || password.isEmpty()) {
            // Show error message if any field is blank
            model.addAttribute("error", "All fields are required.");
            return "signUp"; // Stay on the sign-up page
        }

        // Check if the user already exists by username or email
        boolean status = service.userExists(username, email);

        if (!status) {
            // If user doesn't exist, add the user to the database
            service.addUser(user);
            model.addAttribute("message", "User registered successfully. Please log in.");
            return "login"; // Redirect to login page after successful registration
        } else {
            // If user exists, show error message
            model.addAttribute("error", "Username or Email already exists. Try again.");
            return "signUp"; // Stay on the sign-up page
        }
    }
	@PostMapping("/login")
	public String login(@RequestParam String username,
            @RequestParam String password,
            Model model, HttpSession session) {
			// Validate that fields are not blank
			if (username == null || username.isEmpty() || 
			password == null || password.isEmpty()) {
			// Show error message if any field is blank
			model.addAttribute("error", "Both username and password are required.");
			return "login"; // Stay on the login page
			}
			
			// Validate user credentials
			boolean status = service.validateUser(username, password);
			
			if (status) {
			// If valid, set session attributes and redirect to home page
			session.setAttribute("username", username);
			model.addAttribute("session", session);
			return "index"; // Redirect to home page on successful login
			} else {
			// If invalid, show error message and redirect to login page
			model.addAttribute("error", "Invalid username or password. Please try again.");
			return "login"; // Stay on the login page with error message
			}
		}
				
	}
