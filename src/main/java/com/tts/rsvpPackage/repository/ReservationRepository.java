package com.tts.rsvpPackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.rsvpPackage.model.Event;
import com.tts.rsvpPackage.model.Reservation;
import com.tts.rsvpPackage.model.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	public Reservation findReservationById(Long id);
	public boolean existsByUserAndEvent(User user, Event event);
}
