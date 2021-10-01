package com.huyvu.it.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.converter.TokenConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.MoveDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.EntryPoint;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.Player;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.Token;
import com.huyvu.it.repository.GameRepository;
import com.huyvu.it.repository.PlayerGameRepository;
import com.huyvu.it.repository.PlayerRepository;
import com.huyvu.it.repository.TokenRepository;

@Service
public class GameService {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private TokenConverter tokenConverter;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerGameRepository playerGameRepository;

	@Autowired
	private GameConverter gameConverter;

	private Game game;

	public MoveDto action(MoveDto moveDto, UserDetails userDetails) throws Exception {
		Token token = tokenRepository.findOneById(moveDto.getToken().getId());
		game = gameRepository.findOneById(token.getGame().getId());

		Player player = playerRepository.findOneByUsername(userDetails.getUsername());

		if (!isProperPlayer(player, game)) {
			throw new Exception("Not " + player.getUsername() + " turn!");
		}

		if (!game.isDiced()) {
			// throw new Exception("Dice first to make a " + player.getUsername() + "
			// turn!");
		}

		switch (token.getFieldtype()) {
		case WAYPOINT:
			move(token);
			break;
		case HOMEPOINT:
			if (!isSpecialDiceValue(game)) {
				throw new Exception("Player " + player.getUsername() + " don't have special dice value!");
			}
			entryMove(token);
			break;
		case FINISHPOINT:
			finishMove(token);
			break;

		default:
			break;
		}

		// jump
		game.setDiced(false);
		gameRepository.save(game);

		return updateTokenPosition(moveDto);
	}

	private boolean isSpecialDiceValue(Game game) {
		return game.getDiceValue() == 1 || game.getDiceValue() == 6;
	}

	private void finishMove(Token token) {
		// TODO Auto-generated method stub

	}
	// if the entry point is free, token can move to it
	private void entryMove(Token token) throws Exception {
		
		Field field = EntryPoint.class.getField(token.getColor().toString());
		Token entryPoint = (Token) field.get(Token.class);
		
		if (anAllyStandInDestination(entryPoint)) {
			throw new Exception("Your way point has been block!");
		}
		
		jump(token, entryPoint);
	}



	private void jump(Token token, Token destination) {
		System.out.println("just jump!");

	}

	// if
	private boolean ableToMoveToDestination(Token token) throws Exception {
		Token destination = null;

		if (!waypointIsFree(token) || anAllyStandInDestination(token)) {
			throw new Exception("Waypoint has been block!");
		}

		return true;
	}

	private boolean anAllyStandInDestination(Token token) {
		List<Token> tokens = tokenRepository.findAllByGameId(game.getId());

		List<Token> allys = tokens.stream().filter(e -> e.getFieldtype().equals(token.getFieldtype())
				&& e.getFieldNumber() == token.getFieldNumber() 
				&& e.getColor().equals(token.getColor())).collect(Collectors.toList());
		
		if(allys.size() > 0) {
			return true;
		}

		return false;
	}

	private boolean waypointIsFree(Token token) {
		List<Token> tokens = game.getTokens();
		
		
		
		return false;
	}

	private void move(Token token) {
		// TODO Auto-generated method stub

	}

	private boolean isProperPlayer(Player player, Game game) {
		// return player.getId() == game.getHost().getId();
		return true;
	}

	private MoveDto updateTokenPosition(MoveDto moveDto) {
		Token token = tokenRepository.findOneById(moveDto.getToken().getId());

		token.setFieldtype(moveDto.getDestination().getFieldtype());
		token.setFieldNumber(moveDto.getDestination().getFieldnumber());

		tokenRepository.save(token);

		TokenDto tokenDto = tokenConverter.toDto(token);
		moveDto.setDestination(tokenDto);
		return moveDto;
	}

	public GameDto dice(UserDetails userDetails) throws Exception {
		Player player = playerRepository.findOneByUsername(userDetails.getUsername());

		List<PlayerGame> playerGame = playerGameRepository.findfirstByPlayerIdOrderByCreatedDateDesc(player.getId());

		Game game = playerGame.get(0).getGame();

		if (game.isDiced()) {
			throw new Exception("Not turn to dice!");
		}

		int newDiceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		newDiceValue = 1;
		game.setDiceValue(newDiceValue);
		// game.setDiced(true);
		gameRepository.save(game);

		GameDto result = gameConverter.toCreateGameDto(game);

		return result;
	}

}
