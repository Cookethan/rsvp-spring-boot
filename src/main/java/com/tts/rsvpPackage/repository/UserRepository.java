package com.tts.rsvpPackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.rsvpPackage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserById(Long id);
}
