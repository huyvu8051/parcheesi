package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
	Game findOneById(int id);
	
	List<Game> findAll();

	List<Game> findAll(Sort sort);
}
