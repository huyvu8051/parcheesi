package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	List<Token> findAllByPlayerGamePrimaryKeyGameId(int id);

	Token findOneById(int id);

	Token findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(FieldType waypoint, int desFieldnumber, int gameId);


}
