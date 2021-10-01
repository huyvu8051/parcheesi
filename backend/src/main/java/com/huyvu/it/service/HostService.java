package com.huyvu.it.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Color;
import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.Player;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.Status;
import com.huyvu.it.models.Token;
import com.huyvu.it.repository.GameRepository;
import com.huyvu.it.repository.PlayerGameRepository;
import com.huyvu.it.repository.PlayerRepository;
import com.huyvu.it.repository.TokenRepository;

@Service
public class HostService {
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerGameRepository playerGameRepository;

	@Autowired
	private GameConverter gameConverter;

	public GameDto createGame(GameDto gameDto, Player host) {

		host = playerRepository.findOneByUsername(host.getUsername());

		// create game
		Game game = gameRepository.save(new Game(gameDto.getName(), Status.WAITTING, host));

		// add player host to game
		playerGameRepository.save(new PlayerGame(host, game, true));

		// create all token in this game

		createListToken(game);

		Game game2 = gameRepository.findOneById(game.getId());
		
		List<Token> tokens = tokenRepository.findAllByGameId(game2.getId());

		game2.setTokens(tokens);
		
		GameDto result = gameConverter.toCreateGameDto(game2);

		return result;
	}
	
	private List<Token> createListToken(Game game){
		List<Token> tokens = new ArrayList<>();

		tokens.add(new Token(Color.RED, 1, FieldType.HOMEPOINT, "token" + 1, 30, 150, 50, game));
		tokens.add(new Token(Color.RED, 2, FieldType.HOMEPOINT, "token" + 2, 30, 150, 150, game));
		tokens.add(new Token(Color.RED, 3, FieldType.HOMEPOINT, "token" + 3, 30, 50, 150, game));

		tokens.add(new Token(Color.GREEN, 1, FieldType.HOMEPOINT, "token" + 1, 30, 1050, 950, game));
		tokens.add(new Token(Color.GREEN, 2, FieldType.HOMEPOINT, "token" + 2, 30, 950, 950, game));
		tokens.add(new Token(Color.GREEN, 3, FieldType.HOMEPOINT, "token" + 3, 30, 950, 1050, game));

		tokens.add(new Token(Color.YELLOW, 1, FieldType.HOMEPOINT, "token" + 1, 30, 150, 1050, game));
		tokens.add(new Token(Color.YELLOW, 2, FieldType.HOMEPOINT, "token" + 2, 30, 150, 950, game));
		tokens.add(new Token(Color.YELLOW, 3, FieldType.HOMEPOINT, "token" + 3, 30, 50, 950, game));

		tokens.add(new Token(Color.BLUE, 1, FieldType.HOMEPOINT, "token" + 1, 30, 950, 50, game));
		tokens.add(new Token(Color.BLUE, 2, FieldType.HOMEPOINT, "token" + 2, 30, 950, 150, game));
		tokens.add(new Token(Color.BLUE, 3, FieldType.HOMEPOINT, "token" + 3, 30, 1050, 150, game));
		
		return tokenRepository.saveAll(tokens);
	}
}
