package com.huyvu.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	Game findOneById(int id);
}
