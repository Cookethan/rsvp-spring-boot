package com.tts.rsvpPackage.service;

import java.util.List;

import com.tts.rsvpPackage.model.Event;

public interface EventServiceInt {
	public List<Event> findAllEvents();

	public Event findEventById(Long id);

	public Event saveEvent(Event event);

	public Event updateEvent(Long id, Event event);

	public void deleteEventById(Long id);
}
