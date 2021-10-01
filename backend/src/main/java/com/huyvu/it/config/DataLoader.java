package com.huyvu.it.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private PlayerGameRepository playerGameRepository;

	@Autowired
	private TokenRepository tokenRepository;

	public void run(ApplicationArguments args) {

		System.out.println("================INIT DB=================");

		Player player1 = playerRepository.save(new Player("huyvu1", "huyvu"));
		Player player2 = playerRepository.save(new Player("huyvu2", "huyvu"));
		Player player3 = playerRepository.save(new Player("huyvu3", "huyvu"));
		Player player4 = playerRepository.save(new Player("huyvu4", "huyvu"));

		



		Game game = gameRepository.save(new Game("Game 1", Status.WAITTING, player1));

		List<PlayerGame> playerGames = new ArrayList<>();
		playerGames.add(new PlayerGame(player1, game, false));
		playerGames.add(new PlayerGame(player2, game, false));
		playerGames.add(new PlayerGame(player3, game, false));
		playerGames.add(new PlayerGame(player4, game, false));
		
		
		playerGameRepository.saveAll(playerGames);
		
		

	}
}