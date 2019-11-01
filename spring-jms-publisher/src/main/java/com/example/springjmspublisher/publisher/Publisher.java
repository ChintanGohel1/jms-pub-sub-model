package com.example.springjmspublisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

	@Autowired
	@Qualifier("jmsTemplateTopic")
	private JmsTemplate jmsTemplate;

	public void publishMessage(String publishMessage) {
		jmsTemplate.send(session -> session.createTextMessage(publishMessage));

	}

}
