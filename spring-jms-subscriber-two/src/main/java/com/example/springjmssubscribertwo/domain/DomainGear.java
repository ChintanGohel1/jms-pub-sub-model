package com.example.springjmssubscribertwo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class DomainGear implements Serializable {

	private static final long serialVersionUID = 8164471950454154413L;
	//
	//
	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	// private int id;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(unique = true, columnDefinition = "VARCHAR(32)") //columnDefinition = "BINARY(16)" Not working in ORACLE
	private UUID uuid;

	@CreationTimestamp
	private LocalDateTime created_on;

	@UpdateTimestamp
	private LocalDateTime updated_on;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public LocalDateTime getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(LocalDateTime updated_on) {
		this.updated_on = updated_on;
	}

}
