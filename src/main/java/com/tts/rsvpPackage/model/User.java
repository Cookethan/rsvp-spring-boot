package com.tts.rsvpPackage.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
	
	public User() {}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
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
	
	public void addEvent(Event event) {
		this.events.add(event);
		event.getUsers().add(this);
	}
	
	public void removeEvent(Event event) {
		this.events.remove(event);
		event.getUsers().remove(this);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_event", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="event_id"))
	private Set<Event> events = new HashSet<>();
	
	
}
