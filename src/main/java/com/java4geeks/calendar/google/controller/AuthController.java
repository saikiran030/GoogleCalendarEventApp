package com.java4geeks.calendar.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java4geeks.calendar.google.domain.TokenResponse;
import com.java4geeks.calendar.google.service.AuthService;

@RestController
@RequestMapping("api/v1/google/auth")
public class AuthController {
	@Autowired
	AuthService authService;

	@GetMapping("/authorize")
	public String getAuth(@RequestParam("code") String code) {
	System.out.println(code);
	return code;
	}

	@GetMapping
	public String getAuthCode () {
	return authService.getAuthCode();
	}

	@PostMapping("/token/authcode")
	public TokenResponse getTokenFromAuthCode(@RequestParam("code") String code) {
	TokenResponse tr = authService.getTokenFromAuthCode(code);
	System.out.println("AccessToken ::::: "+tr.getAccessToken());
	System.out.println("RefreshToken ::::: "+tr.getRefreshToken());
	return tr;
	}

	@PostMapping("/token/refreshcode")
	public TokenResponse getTokenFromRefreshCode() {
	return authService.getTokenFromRefreshCode();
	}
}
