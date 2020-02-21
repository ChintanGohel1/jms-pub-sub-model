package com.example.springjmssubscriberone.subscriberone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.springjmssubscriberone.domain.Message;
import com.example.springjmssubscriberone.repository.MessageRepository;

@Component
public class SubscriberOne {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	@Qualifier("jmsTemplateQueue")
	private JmsTemplate jmsTemplate;

	// @JmsListener(containerFactory = "simpleMessageListenerContainer",
	// destination = "TOPIC.1")
	public void onMessage(String msg) {

		Message message = new Message();
		message.setMessage(msg);
		messageRepository.save(message);
		System.out.println("This is msg :" + msg);
		jmsTemplate.convertAndSend("Message Received By Subscriber ONE : " + message);
	}
}
