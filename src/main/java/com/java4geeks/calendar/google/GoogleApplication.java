package com.java4geeks.calendar.google;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleApplication.class, args);
	}

	@Bean
	public Docket eventsApi() {
	return new Docket(DocumentationType.SWAGGER_2).select()
	.apis(RequestHandlerSelectors.basePackage("com.java4geeks.calendar.google")).build();
	}

	@Bean
	    public RestTemplate getRestClient() {
	        RestTemplate restClient = new RestTemplate(
	                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

	        restClient.setInterceptors(Collections.singletonList((request, body, execution) -> {

	            return execution.execute(request, body);
	        }));

	        return restClient;
	    }
}
