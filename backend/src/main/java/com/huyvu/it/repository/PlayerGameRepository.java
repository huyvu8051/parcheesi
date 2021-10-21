package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.huyvu.it.models.Game;
import com.huyvu.it.models.PlayerGame;

public interface PlayerGameRepository extends JpaRepository<PlayerGame, Integer> {
	@Query("Select u from PlayerGame u where u.primaryKey.player.id = :id  order by u.createdDate desc")
	Page<PlayerGame> findfirstByPlayerIdOrderByCreatedDateDesc(@Param("id") int id, Pageable pageable);

	PlayerGame findOneByPrimaryKeyGameIdAndPrimaryKeyPlayerId(int gameId, int playerId);

	List<PlayerGame> findAllByPrimaryKeyGameId(int id);

	List<PlayerGame> findAllByPrimaryKeyGame(Game game);

	List<PlayerGame> findAllByPrimaryKeyGameAndFinishDateIsNull(Game game);

}
