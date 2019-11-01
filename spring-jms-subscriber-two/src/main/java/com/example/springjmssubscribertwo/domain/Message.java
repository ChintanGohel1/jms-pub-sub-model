package com.example.springjmssubscribertwo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JMS_SUBSCRIBER_TWO")
public class Message extends DomainGear {

	private static final long serialVersionUID = -7606583038434283695L;

	@Column(nullable = false)
	private String Message;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "Message [Message=" + Message + "]";
	}

}
