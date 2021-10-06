package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Player {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	@OneToMany(mappedBy = "primaryKey.player")
	private List<PlayerGame> playerGames = new ArrayList<>();
	
	@OneToMany(mappedBy = "host")
	private List<Game> games = new ArrayList<>();

	public Player(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
