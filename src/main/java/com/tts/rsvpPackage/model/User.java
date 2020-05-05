package com.tts.rsvpPackage.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property="id")

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	private String name;
	private String email;
	
	Long reservationRef;
	String reservationStatus;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	Set<Reservation> reservations;
	
	public Long getReservationRef() {
		return reservationRef;
	}

	public void setReservationRef(Long reservatinRef) {
		this.reservationRef = reservatinRef;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Event> getEvents() {
		
		return reservations.stream().map(res->{
			res.event.setReservations(new HashSet<>());
			res.event.setReservationRef(res.id);
			res.event.setReservationStatus(res.status);
			return res.event;
		}).collect(Collectors.toSet());

	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservations = reservation;
	}

	public User() {}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
//	@JsonBackReference

	
	
}
