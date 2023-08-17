package com.java4geeks.calendar.google.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java4geeks.calendar.google.domain.Event;
import com.java4geeks.calendar.google.domain.Events;
import com.java4geeks.calendar.google.domain.TokenResponse;

@Service
public class GoogleService {
	@Autowired
	AuthService authService;
	@Autowired
	AuthHelper authHelper;

	public Event getEvent(String id) {
	TokenResponse tokens = authService.getTokenFromRefreshCode();

	GoogleAPI googleAPI = GoogleServiceBuilder.getGoogleService(tokens.getAccessToken(), authHelper.getEmail());


	Event event = null;

	try {
	event = googleAPI.getEvent(id, authHelper.getKey())
	.execute().body();
	} catch (IOException e) {
	System.out.println("Error  : "+e.getMessage());
	}

	System.out.println(event);
	return event;
	}

	public Events getEvents() {
	TokenResponse tokens = authService.getTokenFromRefreshCode();

	GoogleAPI googleAPI = GoogleServiceBuilder.getGoogleService(tokens.getAccessToken(), authHelper.getEmail());


	Events events = null;

	try {
	events = googleAPI.getEvents(authHelper.getKey())
	.execute().body();
	} catch (IOException e) {
	System.out.println("Error  : "+e.getMessage());
	}

	System.out.println(events);
	return events;
	}

	public Event createEvent(Event event) {
	TokenResponse tokens = authService.getTokenFromRefreshCode();

	GoogleAPI googleAPI = GoogleServiceBuilder.getGoogleService(tokens.getAccessToken(), authHelper.getEmail());


	Event event1 = null;

	try {
	event1 = googleAPI.createEvent(event, authHelper.getKey(),"all", 1)
	.execute().body();
	} catch (IOException e) {
	System.out.println("Error  : "+e.getMessage());
	}

	System.out.println(event1);
	return event1;
	}

	public Event updateEvent(String id, Event event) {
	TokenResponse tokens = authService.getTokenFromRefreshCode();

	GoogleAPI googleAPI = GoogleServiceBuilder.getGoogleService(tokens.getAccessToken(), authHelper.getEmail());


	Event event1 = null;

	try {
	event1 = googleAPI.updateEvent(id,event, authHelper.getKey(),"all", 1)
	.execute().body();
	} catch (IOException e) {
	System.out.println("Error  : "+e.getMessage());
	}

	System.out.println(event1);
	return event1;
	}

	public ResponseBody deleteEvent(String id) {
	TokenResponse tokens = authService.getTokenFromRefreshCode();

	GoogleAPI googleAPI = GoogleServiceBuilder.getGoogleService(tokens.getAccessToken(), authHelper.getEmail());


	ResponseBody responseBody = null;

	try {
	responseBody = googleAPI.deleteEvent(id, authHelper.getKey(),"all", 1)
	.execute().body();
	} catch (IOException e) {
	System.out.println("Error  : "+e.getMessage());
	}

	System.out.println(responseBody);

	return responseBody;
	}

}
