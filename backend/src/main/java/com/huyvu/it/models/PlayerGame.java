package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AssociationOverrides({ @AssociationOverride(name = "primaryKey.player", joinColumns = @JoinColumn(name = "player_id")),
		@AssociationOverride(name = "primaryKey.game", joinColumns = @JoinColumn(name = "game_id")) })
@EntityListeners({ AuditingEntityListener.class })
public class PlayerGame {

	@EmbeddedId
	private PlayerGameId primaryKey = new PlayerGameId();

	private boolean isLogin;

	private Date finishDate;

	@Column(updatable = false)
	private Color color;

	@Column(updatable = false)
	@CreatedDate
	private Date createdDate;

	@Getter
	@Setter
	@OneToMany
	@JoinColumns({ @JoinColumn(name = "game_id", referencedColumnName = "game_id"),
			@JoinColumn(name = "player_id", referencedColumnName = "player_id") })
	private List<Token> tokens = new ArrayList<>();

	@Override
	public boolean equals(Object obj) {

		PlayerGame playerGame = (PlayerGame) obj;

		return getPlayer().getId() == playerGame.getPlayer().getId();
	}

	@Transient
	public Player getPlayer() {
		return getPrimaryKey().getPlayer();
	}

	public void setPlayer(Player player) {
		getPrimaryKey().setPlayer(player);
	}

	@Transient
	public Game getGame() {
		return primaryKey.getGame();
	}

	public void setGame(Game game) {
		getPrimaryKey().setGame(game);
	}

	public PlayerGame(Player player, Game game, boolean isLogin, Color color) {
		primaryKey.setPlayer(player);
		primaryKey.setGame(game);
		this.isLogin = isLogin;
		this.color = color;
	}
}
