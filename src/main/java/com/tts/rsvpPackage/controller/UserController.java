package com.tts.rsvpPackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvpPackage.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/")
	public String index() {
		return "Hello World";
	}
	
//	get all users
//	get user by id
//	create user
//	update user
	// delete users
}
