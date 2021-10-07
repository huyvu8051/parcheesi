package com.huyvu.it.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Player implements UserDetails {
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
	
	
	@Override
	public boolean equals(Object obj) {

		Player player = (Player) obj;

		return getId() == player.getId();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
