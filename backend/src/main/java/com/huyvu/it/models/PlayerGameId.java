package com.huyvu.it.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class PlayerGameId implements Serializable {
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id")
	private Player player;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "game_id")
	private Game game;
}
