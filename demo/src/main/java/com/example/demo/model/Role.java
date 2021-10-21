package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Role {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
}
