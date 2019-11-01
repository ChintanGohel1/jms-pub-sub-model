package com.example.springjmspublisher.publisher;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class PublisherConfig {

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
	public ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setTargetConnectionFactory(connectionFactory());
		connectionFactory.setSessionCacheSize(10);
		return connectionFactory;
	}

	@Bean(name = "jmsTemplateTopic")
	public JmsTemplate jmsTemplateTopic() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setDefaultDestinationName(topicName);
		jmsTemplate.setPubSubDomain(true);
		return jmsTemplate;
	}

}
