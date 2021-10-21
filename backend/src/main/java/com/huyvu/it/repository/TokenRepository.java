package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.Color;
import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.PlayerGameId;
import com.huyvu.it.models.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

	List<Token> findAllByPlayerGamePrimaryKey(PlayerGameId playerGameId);

	List<Token> findAllByPlayerGamePrimaryKeyGameId(int gameId);

	List<Token> findAllByPlayerGamePrimaryKeyGameIdAndColor(int gameId, Color color);

	Token findOneById(int id);

	Token findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(FieldType waypoint, int desFieldnumber,
			int gameId);

	List<Token> findAllByPlayerGame(PlayerGame playerGame);

}
