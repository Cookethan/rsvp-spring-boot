package com.tts.rsvpPackage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.rsvpPackage.model.User;
import com.tts.rsvpPackage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInt {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User userFromForm) {
		User userFromData = findUserById(id);
		BeanUtils.copyProperties(userFromForm, userFromData);
		return userRepository.save(userFromData);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
