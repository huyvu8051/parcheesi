package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String password;
	@Transient
	private String passwordConfirm;
	@ManyToMany(mappedBy = "users")
	private Set<Role> roles;

}
