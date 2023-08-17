package com.java4geeks.calendar.google.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class AuthHelper {
	String authority = "https://accounts.google.com";
	String authorizeUrl = authority + "/o/oauth2/v2/auth";

	@Value("${events.gmail.appid}")
	private String appId;
	@Value("${events.gmail.url}")
	private String redirectUrl;
	@Value("${events.gmail.password}")
	private String appPassword;
	@Value("${events.gmail.authCode}")
	private String authCode;
	@Value("${events.gmail.refreshToken}")
	private String refreshToken;
	@Value("${events.gmail.email}")
	private String email;
	@Value("${events.gmail.accesstype}")
	private String accesstype;
	@Value("${events.gmail.scopes}")
	private String scopes;
	@Value("${events.gmail.key}")
	private String key;


	public String getAuthUrl() {
	UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromHttpUrl(authorizeUrl);
	urlBuilder.queryParam("client_id", getAppId());
	urlBuilder.queryParam("redirect_uri", getRedirectUrl());
	urlBuilder.queryParam("response_type", "code");
	urlBuilder.queryParam("scope", "https://www.googleapis.com/auth/calendar https://www.googleapis.com/auth/calendar.events");
	urlBuilder.queryParam("access_type", getAccesstype());
	urlBuilder.queryParam("state", 12345);

	return urlBuilder.toUriString();
	}

	public String getAuthority() {
	return authority;
	}

	public String getAppId() {
	return appId;
	}

	public String getRedirectUrl() {
	return redirectUrl;
	}

	public String getAppPassword() {
	return appPassword;
	}

	public String getAuthCode() {
	return authCode;
	}


	public String getRefreshToken() {
	return refreshToken;
	}

	public String getScopes() {
	return scopes;
	}

	public String getAccesstype() {
	return accesstype;
	}

	public String getEmail() {
	return email;
	}

	public String getKey() {
	return key;
	}
}
