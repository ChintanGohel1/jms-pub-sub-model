package com.example.springjmspublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.example.springjmspublisher.controller","com.example.springjmspublisher.publisher"})
public class SpringJmsPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsPublisherApplication.class, args);
	}

}
