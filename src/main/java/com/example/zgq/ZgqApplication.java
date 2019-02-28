package com.example.zgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:spring-mvc.xml"})
public class ZgqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZgqApplication.class, args);
	}

}
