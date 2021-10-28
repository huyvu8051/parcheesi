package com.huyvu.it.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.converter.PlayerGameConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Color;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.Player;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.Status;
import com.huyvu.it.repository.GameRepository;
import com.huyvu.it.repository.PlayerGameRepository;

@Service
public class PlayerService {
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GameConverter gameConverter;

	@Autowired
	private PlayerGameRepository playerGameRepository;
	@Autowired
	private PlayerGameConverter playerGameConverter;

	public List<GameDto> findAllGame() {
		List<Game> games = gameRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));

		List<GameDto> result = gameConverter.toListDto(games);

		return result;
	}

	public GameDto join(GameDto gameDto, Player player) throws Exception {

		Game game = gameRepository.findOneById(gameDto.getId());

		if (game.getStatus().equals(Status.CLOSED) || !isPlayerInGame(player, game)
				&& (!game.getStatus().equals(Status.WAITING) || game.getPlayerGames().size() >= 4)) {
			throw new Exception("This room not available!");
		}

		PlayerGame playerGame = playerGameRepository.save(createNewPlayerInGame(player, game));

		Game entity = playerGame.getGame();

		entity.getPlayerGames().add(playerGame);
		
		GameDto result = gameConverter.toDto(entity);

		return result;
	}

	public PlayerGame createNewPlayerInGame(Player player, Game game) {
		List<PlayerGame> playerGames = game.getPlayerGames();
		int lastPlayerIndex = playerGames.size();
		Color[] colors = Color.values();

		PlayerGame playerGame = new PlayerGame();

		playerGame.setColor(colors[lastPlayerIndex]);
		playerGame.setGame(game);
		playerGame.setLogin(true);
		playerGame.setPlayer(player);

		return playerGame;
	}

	private boolean isPlayerInGame(Player player, Game game) {
		List<PlayerGame> players = game.getPlayerGames();

		return players.stream().anyMatch(e -> e.getPlayer().equals(player));
	}

}
