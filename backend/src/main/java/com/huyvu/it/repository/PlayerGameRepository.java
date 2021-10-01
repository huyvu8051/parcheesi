package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huyvu.it.models.PlayerGame;

public interface PlayerGameRepository extends JpaRepository<PlayerGame, Integer> {
	@Modifying
	@Query("Select u from PlayerGame u where u.primaryKey.player.id = :id  order by u.createdDate desc")
	List<PlayerGame> findfirstByPlayerIdOrderByCreatedDateDesc(@Param("id") int id);

}
