package com.fastcampust.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class FastCampustProjectBoardApplication {

	public static void main(String[] args) {


		SpringApplication.run(FastCampustProjectBoardApplication.class, args);
	}

}
