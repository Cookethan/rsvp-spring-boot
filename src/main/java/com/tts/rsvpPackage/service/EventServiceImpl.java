package com.tts.rsvpPackage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.rsvpPackage.model.Event;
import com.tts.rsvpPackage.repository.EventRepository;

@Service
public class EventServiceImpl implements EventServiceInt{

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> findAllEvents() {
		return eventRepository.findAll();
	}
	
	@Override
	public Event findEventById(Long id) {
		return eventRepository.findEventById(id);
	}

	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event updateEvent(Long id, Event eventFromForm) {
		Event eventFromData = findEventById(id);
		BeanUtils.copyProperties(eventFromForm, eventFromData);
		return eventRepository.save(eventFromData);
	}

	@Override
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
	}
}
