package com.tts.rsvpPackage.model;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property="id")
@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="event_id")
	private Long id;

	private String name;
	private String location;
	private Float cost;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	Long reservationRef;
	String reservationStatus;
	
	@OneToMany(mappedBy="event", cascade = CascadeType.ALL)
	Set<Reservation> reservations;
	

	public Event() {}

	public Event(String name, String location, Float cost, Date date) {
		this.name = name;
		this.location = location;
		this.cost = cost;
		this.date = date;
	}
	
	public Long getReservationRef() {
		return reservationRef;
	}
	
	public void setReservationRef(Long reservationRef) {
		this.reservationRef = reservationRef;
	}
	
	public String getReservationStatus() {
		return reservationStatus;
	}
	
	public Set<User> getUsers() {
		
		return reservations.stream().map(res->{	
			res.user.setReservations(new HashSet<>());
			res.user.setReservationRef(res.id);
			res.user.setReservationStatus(res.status);
			return res.user;
		}).collect(Collectors.toSet());

	}
	
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
	
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", location=" + location + ", cost=" + cost + ", date=" + date + "]";
	}
	

	
	
	
}
