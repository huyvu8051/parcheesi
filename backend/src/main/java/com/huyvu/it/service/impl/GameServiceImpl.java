package com.huyvu.it.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
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
import com.huyvu.it.repository.TokenRepository;
import com.huyvu.it.service.GameService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huyvu
 *
 */
@Slf4j
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerGameRepository playerGameRepository;

	@Autowired
	private GameConverter gameConverter;

	/**
	 * is proper player is special dice value
	 * 
	 * @param tokenDto
	 * @param player
	 * @return
	 * @throws Exception
	 */
	@Override
	public GameDto action(TokenDto tokenDto, Player player) throws Exception {

		Token token = tokenRepository.findOneById(tokenDto.getId());

		PlayerGame playerGame = token.getPlayerGame();

		Game game = playerGame.getGame();

		if (isNotProperPlayer(playerGame, game)) {
			throw new Exception("Not " + player.getUsername() + " turn!");
		}

		if (!game.isDiced()) {
			throw new Exception("Dice first to make a " + player.getUsername() + "turn!");
		}

		tryToMove(token, game);

		List<Token> playerGameTokens = tokenRepository.findAllByPlayerGame(playerGame);

		if (isPlayerFinishGame(playerGameTokens)) {
			game.setCurrentPlayer(getNextPlayer(game, playerGame));
			playerGame.setFinishDate(new Date());
			playerGameRepository.save(playerGame);
		} else {
			if (!isSpecialDiceValue(game)) {
				game.setCurrentPlayer(getNextPlayer(game, playerGame));
			}
		}

		if (isGameEnded(game)) {
			game.setStatus(Status.CLOSED);
		}

		game.setDiced(false);

		Game resultEntity = gameRepository.save(game);

		GameDto resultDto = gameConverter.toDto(resultEntity);
		return resultDto;
	}

	/**
	 * @param token
	 * @param game
	 * @throws Exception
	 */
	private void tryToMove(Token token, Game game) throws Exception {
		switch (token.getFieldtype()) {
		case HOMEPOINT:
			entryMove(token, game);
			break;
		case WAYPOINT:
			if (isStandInFinishPointZone(token, game)) {
				finishPointZoneMove(token, game);
				break;
			}
			move(token, game);
			break;
		case FINISHPOINT:
			finishMove(token, game);
			break;

		default:
			break;
		}
	}

	/**
	 * Update isFinish if player have all chess in finish point
	 * 
	 * @param playerGame
	 */
	private boolean isPlayerFinishGame(List<Token> tokens) {

		boolean isAllFinish = tokens.stream().allMatch(e -> e.getFieldtype().equals(FieldType.FINISHPOINT));

		return isAllFinish;
	}

	private boolean isGameEnded(Game game) {
		List<PlayerGame> playerGames = playerGameRepository.findAllByPrimaryKeyGameId(game.getId());

		long numOfPlayerLeft = playerGames.stream().filter(e -> e.getFinishDate() == null).count();

		return numOfPlayerLeft < 2;
	}

	private Color getNextPlayer(Game game, PlayerGame currentPlayer) {
		List<PlayerGame> playerGames = playerGameRepository.findAllByPrimaryKeyGameAndFinishDateIsNull(game);
		int size = playerGames.size();
		playerGames.sort((e1, e2) -> e1.getCreatedDate().compareTo(e2.getCreatedDate()));

		int index = playerGames.indexOf(currentPlayer);

		int currentIndex = (index + 1) % size;

		return playerGames.get(currentIndex).getColor();
	}

	/**
	 * @param token
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private boolean isStandInFinishPointZone(Token token, Game game)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = FinishPointZone.class.getField(game.getCurrentPlayer().toString());
		Token finishPointZone = (Token) field.get(Token.class);
		int position = finishPointZone.getFieldNumber();
		return token.getFieldNumber() == position;
	}

	/**
	 * @param token
	 * @throws Exception
	 */
	private void finishPointZoneMove(Token token, Game game) throws Exception {

		if (destinationIsOutOfRange(game)) {
			throw new Exception("Destination is out of range!");
		}

		Token destination = new Token(token.getPlayerGame().getColor(), game.getDiceValue(), FieldType.FINISHPOINT);

		if (anAllyStandInDestination(game, destination)) {
			throw new Exception("Not available to jump to finish point!");
		}

		if (anyAllyStandBetweenPosAndDesHomePoint(game, token)) {
			throw new Exception("Finish destination has been block!");
		}

		jump(token, destination, game);
	}

	private boolean anyAllyStandBetweenPosAndDesHomePoint(Game game, Token token) {
		List<Integer> fieldNumbersBetweenPosAndDes = new ArrayList<>();

		for (int i = 1; i < game.getDiceValue(); i++) {
			fieldNumbersBetweenPosAndDes.add(i % 32);
		}
		PlayerGame playerGame = findPlayerGameByColor(game.getPlayerGames(), game.getCurrentPlayer());

		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKey(playerGame.getPrimaryKey());

		boolean result = tokens.stream().anyMatch(e -> e.getFieldtype().equals(FieldType.FINISHPOINT)
				&& fieldNumbersBetweenPosAndDes.contains(e.getFieldNumber()));
		return result;
	}

	/**
	 * @param game
	 * @return
	 */
	private boolean destinationIsOutOfRange(Game game) {
		return game.getDiceValue() > 3;
	}

	/**
	 * Check is player have a special dice value
	 * 
	 * @param game current game
	 * @return boolean
	 */
	private boolean isSpecialDiceValue(Game game) {
		return game.getDiceValue() == 1 || game.getDiceValue() == 6;
	}

	private void finishMove(Token token, Game game) throws Exception {

		if (destinationIsOutOfRange(game)) {
			throw new Exception("Destination is out of range!");
		}

		if (game.getDiceValue() != token.getFieldNumber() + 1) {
			throw new Exception("Not valid dice value!");
		}

		Token destination = new Token(token.getPlayerGame().getColor(), game.getDiceValue(), FieldType.FINISHPOINT);

		if (anAllyStandInDestination(game, destination)) {
			throw new Exception("Not available to jump to finish point!");
		}

		jump(token, destination, game);

	}

	/**
	 * A special dice value <br/>
	 * No ally stand in entry point <br/>
	 * 
	 * 
	 * @param token
	 * @throws Exception
	 */

	private void entryMove(Token token, Game game) throws Exception {

		if (!isSpecialDiceValue(game)) {
			throw new Exception("Player don't have special dice value!");
		}

		Token entryPoint = getEntryPointByCurrentPlayer(game.getCurrentPlayer());

		if (anAllyStandInDestination(game, entryPoint)) {
			throw new Exception("Your way point has been block by an ally!");
		}

		jump(token, entryPoint, game);
	}

	private Token getEntryPointByCurrentPlayer(Color color)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = EntryPoint.class.getField(color.toString());
		return (Token) field.get(Token.class);
	}

	/**
	 * @param token
	 * @throws Exception
	 */
	private void move(Token token, Game game) throws Exception {
		int desFieldnumber = (token.getFieldNumber() + game.getDiceValue()) % 32;

		Token desToken = tokenRepository.findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(
				FieldType.WAYPOINT, desFieldnumber, game.getId());

		// no ally stand at destination
		if (desToken != null && anAllyStandInDestination(game, desToken)) {
			throw new Exception("Your destination has been block by an ally!");
		}

		// no Token stand between current position and destination
		if (anyTokenStandBetweenPosAndDes(game, token)) {
			throw new Exception("Your way point has been block");
		}

		// do not go more than one round
		if (isGoMoreThanOneRound(game, token)) {
			throw new Exception("Do not go more than one round!");
		}

		Token destination = new Token(token.getColor(), desFieldnumber, token.getFieldtype());

		jump(token, destination, game);
	}

	/**
	 * Check if token go more than one round
	 * 
	 * @param game
	 * @param token
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private boolean isGoMoreThanOneRound(Game game, Token token)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = FinishPointZone.class.getField(game.getCurrentPlayer().toString());
		Token finishPointZone = (Token) field.get(Token.class);

		return token.getFieldNumber() < finishPointZone.getFieldNumber()
				&& token.getFieldNumber() + game.getDiceValue() > finishPointZone.getFieldNumber();
	}

	/**
	 * At way point
	 * 
	 * @param game
	 * @param token
	 * @return
	 */
	private boolean anyTokenStandBetweenPosAndDes(Game game, Token token) {

		List<Integer> fieldNumbersBetweenPosAndDes = new ArrayList<>();

		for (int i = token.getFieldNumber() + 1; i < token.getFieldNumber() + game.getDiceValue(); i++) {
			fieldNumbersBetweenPosAndDes.add(i % 32);
		}

		PlayerGame playerGame = findPlayerGameByColor(game.getPlayerGames(), game.getCurrentPlayer());
		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKeyGameId(playerGame.getGame().getId());

		return tokens.stream().anyMatch(e -> e.getFieldtype().equals(FieldType.WAYPOINT)
				&& fieldNumbersBetweenPosAndDes.contains(e.getFieldNumber()));

	}

	/**
	 * if contain a token at destination, move it to home point
	 * 
	 * @param token destination
	 */
	private void strikeIfExistAtDestination(Token token, Game game) {
		Token desToken = tokenRepository.findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(
				FieldType.WAYPOINT, token.getFieldNumber(), game.getId());
		if (desToken != null) {
			desToken.setFieldNumber(desToken.getHomeFieldnumber());
			desToken.setColor(desToken.getPlayerGame().getColor());
			desToken.setFieldtype(FieldType.HOMEPOINT);
			tokenRepository.save(desToken);
		}

	}

	/**
	 * change position of token to destination position
	 * 
	 * @param token
	 * @param destination
	 */
	private void jump(Token token, Token destination, Game game) {

		strikeIfExistAtDestination(destination, game);

		token.setFieldNumber(destination.getFieldNumber());
		token.setFieldtype(destination.getFieldtype());
		token.setColor(destination.getColor());
		tokenRepository.save(token);
	}

	/**
	 * Get list of ally (Current player) token, Check any Ally stand in destination
	 * 
	 * @param game        current game
	 * @param color       color of ally
	 * @param destination destination of table we want to check
	 * @return boolean
	 */
	private boolean anAllyStandInDestination(Game game, Token destination) {

		PlayerGame playerGame = findPlayerGameByColor(game.getPlayerGames(), game.getCurrentPlayer());

		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKey(playerGame.getPrimaryKey());

		boolean result = tokens.stream().anyMatch(e -> e.equals(destination));

		return result;
	}

	/**
	 * @param playerGames
	 * @param color
	 * @return
	 */
	private PlayerGame findPlayerGameByColor(List<PlayerGame> playerGames, Color color) {
		Optional<PlayerGame> optional = playerGames.stream().filter(e -> e.getColor().equals(color)).findFirst();
		return optional.get();
	}

	/**
	 * are you current player
	 * 
	 * @param player
	 * @param game
	 * @return boolean
	 */
	private boolean isNotProperPlayer(PlayerGame playerGame, Game game) {
		return !playerGame.getColor().equals(game.getCurrentPlayer());
	}

	/**
	 * Dice the last game player created
	 * 
	 * @param player
	 * @return
	 * @throws Exception
	 */
	public GameDto dice(Player player) throws Exception {

		Pageable limit = PageRequest.of(0, 1);

		Page<PlayerGame> playerGame = playerGameRepository.findfirstByPlayerIdOrderByCreatedDateDesc(player.getId(),
				limit);

		Optional<PlayerGame> optional = playerGame.get().findFirst();

		Game game = optional.get().getGame();

		if (game.isDiced()) {
			throw new Exception("Not turn to dice!");
		}

		int newDiceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);

		game.setDiceValue(newDiceValue);
		game.setDiced(true);

		if (!isAvailableToTakeTurn(game)) {
			if (!isSpecialDiceValue(game)) {
				game.setCurrentPlayer(getNextPlayer(game, optional.get()));
			}
			game.setDiced(false);

		}
		gameRepository.save(game);
		GameDto result = gameConverter.toDto(game);

		return result;
	}

	/**
	 * @param game
	 * @return
	 */
	private boolean isAvailableToTakeTurn(Game game) {
		PlayerGame playerGame = findPlayerGameByColor(game.getPlayerGames(), game.getCurrentPlayer());

		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKey(playerGame.getPrimaryKey());

		for (Token token : tokens) {
			try {
				isTokenAbleToMove(game, token);
				return true;
			} catch (Exception e) {
				// log.error(e.getMessage() + "=================================");
			}
		}
		return false;

	}

	/**
	 * @param token
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws Exception
	 */
	private void isTokenAbleToMove(Game game, Token token) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, Exception {
		switch (token.getFieldtype()) {
		case HOMEPOINT:
			if (!isSpecialDiceValue(game)) {
				throw new Exception("Player don't have special dice value!");
			}
			Field field = EntryPoint.class.getField(game.getCurrentPlayer().toString());
			Token entryPoint = (Token) field.get(Token.class);

			if (anAllyStandInDestination(game, entryPoint)) {
				throw new Exception("Your way point has been block by an ally!");
			}
			break;
		case WAYPOINT:
			if (isStandInFinishPointZone(token, game)) {
				Token destination = new Token(token.getPlayerGame().getColor(), game.getDiceValue(),
						FieldType.FINISHPOINT);

				if (destinationIsOutOfRange(game) || anAllyStandInDestination(game, destination)
						|| anyAllyStandBetweenPosAndDesHomePoint(game, token)) {
					throw new Exception("Destination is out of range!");
				}

				break;
			}
			int desFieldnumber = (token.getFieldNumber() + game.getDiceValue()) % 32;

			Token desToken = tokenRepository.findOneByFieldtypeAndFieldNumberAndPlayerGamePrimaryKeyGameId(
					FieldType.WAYPOINT, desFieldnumber, game.getId());

			// no ally stand at destination
			if ((desToken != null && anAllyStandInDestination(game, desToken))
					|| anyTokenStandBetweenPosAndDes(game, token) || isGoMoreThanOneRound(game, token)) {
				throw new Exception("Your destination has been block by an ally!");
			}
			break;
		case FINISHPOINT:
			Token destination = new Token(token.getPlayerGame().getColor(), game.getDiceValue(), FieldType.FINISHPOINT);
			if (destinationIsOutOfRange(game) || (game.getDiceValue() != token.getFieldNumber() + 1)
					|| anAllyStandInDestination(game, destination)) {
				throw new Exception();
			}
			break;

		default:
			break;
		}
	}

	/**
	 * load game
	 * 
	 * @param gameDto
	 * @param player
	 * @return
	 * @throws Exception
	 */
	public GameDto loadGame(GameDto gameDto, Player player) throws Exception {

		Game game = gameRepository.findOneById(gameDto.getId());

		if (!isPlayerJoinedGame(game, player)) {
			throw new Exception("You not in this game!");
		}

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	/**
	 * check is player join this game
	 * 
	 * @param game
	 * @param player
	 * @return
	 */
	private boolean isPlayerJoinedGame(Game game, Player player) {
		List<PlayerGame> players = game.getPlayerGames();
		return players.stream().anyMatch(e -> e.getPlayer().getId() == player.getId());
	}

	/**
	 * Start the last game which player created
	 * 
	 * @param gameDto
	 * @param player
	 * @return
	 * @throws Exception
	 */
	public GameDto start(GameDto gameDto, Player player) throws Exception {

		Game game = gameRepository.findOneById(gameDto.getId());

		if (game.getStatus() == Status.WAITING) {
			game.setStatus(Status.IN_PROGRESS);
			createListToken(game);
			gameRepository.save(game);
		}

		GameDto result = gameConverter.toDto(game);

		return result;
	}

	/**
	 * Create list token base on playerGames in game
	 * 
	 * @param game
	 */
	private void createListToken(Game game) {

		List<Token> tokens = new ArrayList<>();

		for (PlayerGame playerGame : game.getPlayerGames()) {

			Color color = playerGame.getColor();

			for (int i = 1; i <= 3; i++) {
				tokens.add(new Token(color, i, FieldType.HOMEPOINT, i, playerGame));
			}

		}

		tokenRepository.saveAll(tokens);

	}

}
