package com.tts.rsvpPackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.rsvpPackage.model.User;
import com.tts.rsvpPackage.service.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping()
	public List<User> getUsers() {
		return userServiceImpl.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userServiceImpl.findUserById(id);
	}
	
	@PostMapping()
	public User createUser(@RequestBody User user) {
		return userServiceImpl.saveUser(user);
	}
	
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userServiceImpl.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUserById(id);
	}

}
