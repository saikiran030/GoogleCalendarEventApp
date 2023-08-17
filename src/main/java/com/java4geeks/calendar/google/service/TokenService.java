package com.java4geeks.calendar.google.service;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.java4geeks.calendar.google.domain.TokenResponse;

public interface TokenService {
	@FormUrlEncoded
	@POST("/token")
	Call<TokenResponse> getAccessTokenFromAuthCode(
	@Field("client_id") String clientId,
	@Field("client_secret") String clientSecret,
	@Field("grant_type") String grantType,
	@Field("code") String code,
	@Field("redirect_uri") String redirectUrl
	);

	@FormUrlEncoded
	@POST("/token")
	Call<TokenResponse> getAccessTokenFromRefreshToken(
	@Field("client_id") String clientId,
	@Field("client_secret") String clientSecret,
	@Field("grant_type") String grantType,
	@Field("refresh_token") String code
	);

}
