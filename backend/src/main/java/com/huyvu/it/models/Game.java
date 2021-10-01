package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Status status;

	private int diceValue;
	
	private boolean isDiced;
	
	@CreatedDate
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "host_id")
	private Player host;

	@OneToMany(mappedBy = "primaryKey.game")
	private List<PlayerGame> playerGames = new ArrayList<>();

	@OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
	private List<Token> tokens = new ArrayList<>();

	public Game(String name, Status status, Player host) {
		this.name = name;
		this.status = status;
		this.host = host;
		this.diceValue = 0;
		this.isDiced = false;
	}
	

}
