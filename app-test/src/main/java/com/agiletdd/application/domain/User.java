package com.agiletdd.application.domain;

import java.time.Instant;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Access(AccessType.FIELD)
public class User {

	private static final int MIN_NAME_LENGTH = 3;

	@Id
	private UUID id;

	@Column()
	private String name;

	@Column(name = "creation_date")
	private Instant creationInstant;

	@Column()
	private String city;

	private User() {
	}

	public User(String name, String city) {
		if (name.length() < MIN_NAME_LENGTH)
			throw new InvalidUserParameterException("User name must be greater than 3");

		this.id = UUID.randomUUID();
		this.name = name;
		this.city = city;
		this.creationInstant = Instant.now();
	}

	public User(String name){
		this(name,null);
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Instant getCreationInstant() {
		return creationInstant;
	}

	public String getCity() {
		return city;
	}
}
