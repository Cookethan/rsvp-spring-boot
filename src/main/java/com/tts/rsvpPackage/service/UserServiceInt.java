package com.tts.rsvpPackage.service;

import java.util.List;

import com.tts.rsvpPackage.model.User;

public interface UserServiceInt {
	public List<User> findAllUsers();

	public User findUserById(Long id);

	public User saveUser(User user);

	public User updateUser(Long id, User user);

	public void deleteUserById(Long id);
}
