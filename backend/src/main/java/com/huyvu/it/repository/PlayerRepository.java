package com.huyvu.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	Player findOneByUsername(String username);
}
