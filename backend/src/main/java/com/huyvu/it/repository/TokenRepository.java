package com.huyvu.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

	List<Token> findAllByGameId(int gameId);

	Token findOneById(int id);


}
