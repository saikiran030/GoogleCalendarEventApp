package com.java4geeks.calendar.google.service;

import org.springframework.web.bind.annotation.ResponseBody;

import com.java4geeks.calendar.google.domain.Event;
import com.java4geeks.calendar.google.domain.Events;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleAPI {
	@GET("/calendar/v3/calendars/primary/events/{id}")
	Call<Event> getEvent(@Path("id") String id, @Query("key") String key);

	@GET("/calendar/v3/calendars/primary/events")
	Call<Events> getEvents(@Query("key") String key);

	@POST("/calendar/v3/calendars/primary/events")
	Call<Event> createEvent(@Body Event event, @Query("key") String key, @Query("sendUpdates") String sendUpdates, @Query("conferenceDataVersion") int conferenceDataVersion);

	@PATCH("/calendar/v3/calendars/primary/events/{id}")
	Call<Event> updateEvent(
	@Path("id") String id,
	@Body Event event, @Query("key") String key, @Query("sendUpdates") String sendUpdates, @Query("conferenceDataVersion") int conferenceDataVersion
	);

	@DELETE("/calendar/v3/calendars/primary/events/{id}")
	Call<ResponseBody> deleteEvent(
	@Path("id") String id,
	@Query("key") String key, @Query("sendUpdates") String sendUpdates, @Query("conferenceDataVersion") int conferenceDataVersion
	);
}
