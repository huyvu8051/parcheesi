package com.huyvu.it.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.huyvu.it.models.Player;
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
		Player player5 = playerRepository.save(new Player("huyvu5", "huyvu"));

//		Game game = gameRepository.save(new Game("Game 1", Status.WAITING, player1));
//		Game game2 = gameRepository.save(new Game("Game 2", Status.IN_PROGRESS, player2));
//		Game game3 = gameRepository.save(new Game("Game 3", Status.CLOSED, player3));
//		Game game4 = gameRepository.save(new Game("Game 4", Status.WAITING, player4));

//		List<PlayerGame> playerGames = new ArrayList<>();
//		playerGames.add(new PlayerGame(player1, game, false));
//		playerGames.add(new PlayerGame(player2, game, false));
//		playerGames.add(new PlayerGame(player3, game, false));
//		playerGames.add(new PlayerGame(player4, game, false));
//
//		playerGameRepository.saveAll(playerGames);

	}
}