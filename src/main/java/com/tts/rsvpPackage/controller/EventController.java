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

import com.tts.rsvpPackage.model.Event;
import com.tts.rsvpPackage.service.EventServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventServiceImpl eventServiceImpl;

	@GetMapping()
	public List<Event> getEvents() {
		return eventServiceImpl.findAllEvents();
	}
	
	@GetMapping("/{id}")
	public Event findEventById(@PathVariable Long id) {
		return eventServiceImpl.findEventById(id);
	}
	
	@PostMapping()
	public Event createEvent(@RequestBody Event event) {
		return eventServiceImpl.saveEvent(event);
	}
	
	
	@PutMapping("/{id}")
	public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
		return eventServiceImpl.updateEvent(id, event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventServiceImpl.deleteEventById(id);
	}

}
