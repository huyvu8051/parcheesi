package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.PlayerGameId;
import com.huyvu.it.models.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	List<Token> findAllByPlayerGamePrimaryKeyGameId(int id);

	Token findOneById(int id);

	Token findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(FieldType waypoint, int desFieldnumber, int gameId);

	List<Token> findAllByPlayerGamePrimaryKey(PlayerGameId primaryKey);

	List<Token> findAllByPlayerGame(PlayerGame playerGame);


}
