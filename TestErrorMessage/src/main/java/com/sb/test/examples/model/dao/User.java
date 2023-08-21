package com.sb.test.examples.model.dao;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "my_user")
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(nullable = false, unique = true)
	private String firstName;

	private String lastName;

	private String age;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private String phoneNumber;

	private String emailId;

}
