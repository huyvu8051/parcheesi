package com.huyvu.it.models;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import lombok.Getter;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "primaryKey.student", joinColumns = @JoinColumn(name = "student_id")),
		@AssociationOverride(name = "primaryKey.challenge", joinColumns = @JoinColumn(name = "challenge_id")) })
public class PlayerGame {
	private boolean isLogin;

	@EmbeddedId
	@Getter
	private PlayerGameId primaryKey = new PlayerGameId();

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

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
}
