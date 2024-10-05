package com.AmazonClone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.AmazonClone.services.UserService;


@Controller
public class NavigationController {
	@Autowired
	UserService service;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUpPage")
	public String openSignUpPage() {
	    return "signUp";  // Matches the name of your template
	}
}