package com.java4geeks.calendar.google.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@GetMapping
	public String getAuthCode () {
	return "sample";
	}
}
