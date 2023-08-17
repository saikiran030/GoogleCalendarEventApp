package com.java4geeks.calendar.google.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java4geeks.calendar.google.domain.TokenResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class AuthService {

	@Autowired
	AuthHelper authHelper;
	@Autowired
	RestTemplate restTemplate;

	public String getAuthCode() {
	String url = authHelper.getAuthUrl();
	System.out.println(url);
	ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
	return result.getBody();
	}

	public TokenResponse getTokenFromAuthCode(String code) {
	HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

	interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

	OkHttpClient client = new OkHttpClient.Builder()
	.addInterceptor(interceptor).build();

	// Create and configure the Retrofit object
	Retrofit retrofit = new Retrofit.Builder()
	.baseUrl("https://oauth2.googleapis.com")
	.client(client)
	.addConverterFactory(JacksonConverterFactory.create())
	.build();
	// Generate the token service
	TokenService tokenService = retrofit.create(TokenService.class);

	try {
	return tokenService.getAccessTokenFromAuthCode(authHelper.getAppId(), authHelper.getAppPassword(),
	"authorization_code", code, authHelper.getRedirectUrl()).execute().body();
	} catch (IOException e) {
	TokenResponse error = new TokenResponse();
	System.out.println("########### "+e.getMessage());
	System.out.println("******** "+error);
	return error;
	}
	}

	public TokenResponse getTokenFromRefreshCode() {
	HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

	interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

	OkHttpClient client = new OkHttpClient.Builder()
	.addInterceptor(interceptor).build();

	// Create and configure the Retrofit object
	Retrofit retrofit = new Retrofit.Builder()
	.baseUrl("https://oauth2.googleapis.com")
	.client(client)
	.addConverterFactory(JacksonConverterFactory.create())
	.build();

	// Generate the token service
	TokenService tokenService = retrofit.create(TokenService.class);

	try {
	return tokenService.getAccessTokenFromRefreshToken(authHelper.getAppId(), authHelper.getAppPassword(),
	"refresh_token", authHelper.getRefreshToken()).execute().body();
	} catch (IOException e) {
	TokenResponse error = new TokenResponse();
	System.out.println("########### "+e.getMessage());
	System.out.println("******** "+error);
	return error;
	}
	}

}
