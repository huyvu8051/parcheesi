package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({ AuditingEntityListener.class })
public class Game {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Status status;

	private int diceValue;

	private boolean isDiced;

	private Color currentPlayer;
	
	@CreatedDate
	private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "host_id")
	private Player host;

	@OneToMany(mappedBy = "primaryKey.game")
	private List<PlayerGame> playerGames = new ArrayList<>();

	public Game(String name, Status status, Color currentPlayer, Player host) {
		this.name = name;
		this.status = status;
		this.currentPlayer = currentPlayer;
		this.host = host;
		this.diceValue = 1;
		this.isDiced = false;
	}

}
