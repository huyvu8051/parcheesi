package com.huyvu.it.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.converter.TokenConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Color;
import com.huyvu.it.models.EntryPoint;
import com.huyvu.it.models.FieldType;
import com.huyvu.it.models.FinishPointZone;
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

	public GameDto action(TokenDto tokenDto, Player player) throws Exception {
		Token token = tokenRepository.findOneById(tokenDto.getId());
		game = gameRepository.findOneById(token.getPlayerGame().getGame().getId());

		if (!isProperPlayer(player, game)) {
			throw new Exception("Not " + player.getUsername() + " turn!");
		}

		if (!game.isDiced()) {
			// throw new Exception("Dice first to make a " + player.getUsername() + "
			// turn!");
		}

		switch (token.getFieldtype()) {
		case WAYPOINT:
			if (isStandInFinishPointZone(token)) {
				superMove(token);
				break;
			}
			move(token);
			break;
		case HOMEPOINT:

			if (!isSpecialDiceValue(game)) {
				// throw new Exception("Player " + player.getUsername() + " don't have special
				// dice value!");
			}
			entryMove(token);
			break;
		case FINISHPOINT:
			finishMove(token);
			break;

		default:
			break;
		}

		if (!isSpecialDiceValue(game)) {
			game.setCurrentPlayer(getNextPlayer(game));
		}

		checkGameEnded(game);

		game.setDiced(false);
		gameRepository.save(game);

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	private void checkGameEnded(Game game2) {

		

	}

	private Player getNextPlayer(Game game) {
		List<PlayerGame> playerGames = game.getPlayerGames();
		int size = playerGames.size();
		playerGames.sort((e1, e2) -> e1.getCreatedDate().compareTo(e2.getCreatedDate()));

		PlayerGame currentPlayer = new PlayerGame(game.getCurrentPlayer(), null, false, Color.BLUE);

		int index = playerGames.indexOf(currentPlayer);

		int currentIndex = (index + 1) % size;

		return playerGames.get(currentIndex).getPlayer();
	}

	private boolean isStandInFinishPointZone(Token token) {
		FinishPointZone enumInstance = FinishPointZone.valueOf(token.getPlayerGame().getColor().toString());
		int position = enumInstance.getValue();
		return token.getFieldNumber() == position;
	}

	private void superMove(Token token) throws Exception {
		if (!isAvailableToJumpToFinishPoint(token)) {
			throw new Exception("Not available to jump to finish point!");
		}
		token.setColor(token.getPlayerGame().getColor());
		token.setFieldNumber(game.getDiceValue());
		token.setFieldtype(FieldType.FINISHPOINT);

		tokenRepository.save(token);
	}

	private boolean isAvailableToJumpToFinishPoint(Token token) {
		if (game.getDiceValue() < 1 || game.getDiceValue() > 3) {
			return false;
		}
		/*
		 * check is finish way blocked
		 *
		 *
		 */
		return true;
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

	private void move(Token token) {
		int desFieldnumber = (token.getFieldNumber() + game.getDiceValue()) % 32;

		Token desToken = tokenRepository.findOneByFieldtypeAndFieldNumber(FieldType.WAYPOINT, desFieldnumber);

		if (desToken != null) {
			strike(desToken);
		}

		token.setFieldNumber(desFieldnumber);
		tokenRepository.save(token);
	}

	private void strike(Token token) {
		token.setFieldNumber(token.getHomeFieldnumber());
		token.setColor(token.getPlayerGame().getColor());
		token.setFieldtype(FieldType.HOMEPOINT);
		tokenRepository.save(token);

	}

	private void jump(Token token, Token destination) {
		System.out.println("just jump!");

		token.setFieldNumber(destination.getFieldNumber());
		token.setFieldtype(destination.getFieldtype());
		token.setColor(destination.getColor());
		tokenRepository.save(token);

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
		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKeyGameId(game.getId());

		List<Token> allys = tokens.stream()
				.filter(e -> e.getFieldtype().equals(token.getFieldtype())
						&& e.getFieldNumber() == token.getFieldNumber() && e.getColor().equals(token.getColor()))
				.collect(Collectors.toList());

		if (allys.size() > 0) {
			return true;
		}

		return false;
	}

	private boolean waypointIsFree(Token token) {
		

		return false;
	}

	private boolean isProperPlayer(Player player, Game game) {
		// return player.getId() == game.getHost().getId();
		return true;
	}

	private TokenDto updateTokenPosition(Token token) {
		token = tokenRepository.findOneById(token.getId());
		TokenDto tokenDto = tokenConverter.toDto(token);
		return tokenDto;
	}

	public GameDto dice(Player player) throws Exception {

		List<PlayerGame> playerGame = playerGameRepository.findfirstByPlayerIdOrderByCreatedDateDesc(player.getId());

		Game game = playerGame.get(0).getGame();

//		if (game.isDiced()) {
//			throw new Exception("Not turn to dice!");
//		}

		int newDiceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		// newDiceValue = 1;
		game.setDiceValue(newDiceValue);
		game.setDiced(true);
		gameRepository.save(game);

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	public GameDto loadGame(GameDto gameDto, Player player) throws Exception {

		/*
		 * if (!isPlayerJoinedGame(gameDto.getId(), userDetails.getUsername())) { throw
		 * new Exception("You not in this game!"); }
		 */

		Game game = gameRepository.findOneById(gameDto.getId());

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	private boolean isPlayerJoinedGame(int id, String username) {
		Player player = playerRepository.findOneByUsername(username);
		Game game = gameRepository.findOneById(id);
		List<PlayerGame> players = game.getPlayerGames();
		return players.stream().anyMatch(e -> e.getPlayer().getId() == player.getId());
	}

	public GameDto start(GameDto gameDto, Player player) {

		Game game = gameRepository.findOneById(gameDto.getId());
		game.setStatus(Status.IN_PROGRESS);
		createListToken(game);
		gameRepository.save(game);

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	private void createListToken(Game game) {
		
		List<Token> tokens = new ArrayList<>();
		
		for (PlayerGame playerGame : game.getPlayerGames()) {
			
			Color color = playerGame.getColor();

			for (int i = 1; i <= 3; i++) {
				tokens.add(new Token(color, i, FieldType.HOMEPOINT, i, playerGame));
			}

			tokenRepository.saveAll(tokens);

		}

		tokenRepository.saveAll(tokens);

	}

}
