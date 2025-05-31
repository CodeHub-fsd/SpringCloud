package com.stackroute.RestFul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestFulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFulApplication.class, args);
	}

}
