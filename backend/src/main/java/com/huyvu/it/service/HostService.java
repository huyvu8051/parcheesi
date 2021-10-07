package com.huyvu.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.Player;
import com.huyvu.it.models.Status;
import com.huyvu.it.models.Token;
import com.huyvu.it.repository.GameRepository;
import com.huyvu.it.repository.PlayerGameRepository;
import com.huyvu.it.repository.TokenRepository;

@Service
public class HostService {
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private PlayerGameRepository playerGameRepository;

	@Autowired
	private GameConverter gameConverter;
	
	@Autowired
	private PlayerService playerService;

	public GameDto createGame(GameDto gameDto, Player host) {

		// create game
		Game game = gameRepository.save(new Game(gameDto.getName(), Status.WAITING, host, host));

		// add player host to game
		playerGameRepository.save(playerService.createNewPlayerInGame(host, game));

		// create all token in this game



		Game game2 = gameRepository.findOneById(game.getId());
		
		
		GameDto result = gameConverter.toDto(game2);

		return result;
	}
	
	
}
