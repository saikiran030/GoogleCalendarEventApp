package com.java4geeks.calendar.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.java4geeks.calendar.google.domain.Event;
import com.java4geeks.calendar.google.domain.Events;
import com.java4geeks.calendar.google.service.GoogleService;

@RestController
@RequestMapping("api/v1/google/events")
public class CalendarController {
	@Autowired
	GoogleService googleService;

	@GetMapping("/{id}")
	public Event getEvent(@PathVariable("id") String id) {
	return googleService.getEvent(id);
	}

	@GetMapping
	public Events getEvents() {
	return googleService.getEvents();
	}

	@PostMapping("/create")
	public Event createCalendarEvent(@RequestBody Event event) {
	return googleService.createEvent(event);
	}

	@PatchMapping("/update/{id}")
	public Event getUpdateCalendarEvents(@PathVariable("id") String id, @RequestBody Event event) {
	return googleService.updateEvent(id, event);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseBody getDeleteCalendarEvents(@PathVariable("id") String id) {
	return googleService.deleteEvent(id);
	}
}
