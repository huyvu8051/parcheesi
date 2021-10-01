package com.huyvu.it.models;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AssociationOverrides({
		@AssociationOverride(name = "primaryKey.student", joinColumns = @JoinColumn(name = "student_id")),
		@AssociationOverride(name = "primaryKey.challenge", joinColumns = @JoinColumn(name = "challenge_id")) })
@EntityListeners({AuditingEntityListener.class})
public class PlayerGame {
	

	@EmbeddedId
	@Getter
	private PlayerGameId primaryKey = new PlayerGameId();
	
	private boolean isLogin;
	
	@Getter
	@Setter
	@CreatedDate
	private Date createdDate;

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
	
	public PlayerGame(Player player, Game game, boolean isLogin) {
		primaryKey.setPlayer(player);
		primaryKey.setGame(game);
		this.isLogin = isLogin;
	}
}
