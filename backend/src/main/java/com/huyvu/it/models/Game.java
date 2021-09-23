package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Game {
	@Id
	private int id;
	private String name;
	private Status status;
	
	private int diced;
	

	@OneToMany(mappedBy = "primaryKey.game")
	private List<PlayerGame> playerGames = new ArrayList<>();
	
	@OneToMany(mappedBy = "game")
	private List<WayPoint> wayPoints = new ArrayList<>();
	
	public Game () {
		this.name = "New game";
		this.status = Status.WAITTING;
		this.diced = 0;
		
	}

}
