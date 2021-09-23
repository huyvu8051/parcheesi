package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Player {
	@Id
	private int id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "primaryKey.player")
	private List<PlayerGame> playerGames = new ArrayList<>();
}
