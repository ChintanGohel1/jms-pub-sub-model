package com.example.springjmspublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjmspublisher.publisher.Publisher;

@RestController
public class PublisherController {

	public static final String PATH_PUBLISH_MESSAGE = "/publishMessage/{msg}";
	
	
	@Autowired
	private Publisher publisher;
	
	@PostMapping(path=PATH_PUBLISH_MESSAGE)
	public void publishMessage(@PathVariable(name = "msg") String publishMessage){
		publisher.publishMessage(publishMessage);
	}
	
	
}
