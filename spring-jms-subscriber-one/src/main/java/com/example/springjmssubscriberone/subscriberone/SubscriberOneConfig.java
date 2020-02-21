package com.example.springjmssubscriberone.subscriberone;

import java.net.UnknownHostException;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class SubscriberOneConfig {

	@Value("${jms.broker.url}")
	private String broker;

	@Value("${jms.topic.name}")
	private String topicName;

	@Value("${jms.queue.name}")
	private String queueName;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(broker);
		return connectionFactory;
	}

	@Bean
	public MessageListenerAdapter adapterTopic(SubscriberOne subscriberOne) {
		MessageListenerAdapter listener = new MessageListenerAdapter(subscriberOne);
		listener.setDefaultListenerMethod("onMessage");
		listener.setMessageConverter(new SimpleMessageConverter());
		return listener;

	}

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(MessageListenerAdapter messageListenerAdapter)
			throws UnknownHostException {

		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setDestinationName(topicName);
		simpleMessageListenerContainer.setPubSubDomain(true);
		simpleMessageListenerContainer.setSubscriptionDurable(true);
		simpleMessageListenerContainer.setDurableSubscriptionName("INTECH");
		simpleMessageListenerContainer.setClientId("SUBSCRIBER ONE");
		simpleMessageListenerContainer.setMessageListener(messageListenerAdapter);
		return simpleMessageListenerContainer;

	}

	@Bean(name = "jmsTemplateQueue")
	public JmsTemplate jmsTemplatequeue() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName(queueName);
		// jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		return jmsTemplate;
	}

	// @Bean
	// public DefaultJmsListenerContainerFactory
	// defaultJmsListenerContainerFactory() {
	// DefaultJmsListenerContainerFactory factory = new
	// DefaultJmsListenerContainerFactory();
	// factory.setConnectionFactory(connectionFactory());
	// factory.setPubSubDomain(true);
	// return factory;
	// }
}
