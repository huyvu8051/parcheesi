package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.PlayerDto;
import com.huyvu.it.dto.PlayerGameDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Game;
import com.huyvu.it.models.PlayerGame;
import com.huyvu.it.models.Token;
import com.huyvu.it.repository.TokenRepository;

@Component
public class GameConverter {

	@Autowired
	private TokenConverter tokenConverter;

	@Autowired
	private PlayerConverter playerConverter;
	
	@Autowired
	private PlayerGameConverter playerGameConverter;
	
	@Autowired
	private TokenRepository tokenRepository;

	public GameDto toDto(Game entity) {
		GameDto dto = new GameDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setDiceValue(entity.getDiceValue());
		dto.setDiced(entity.isDiced());
		dto.setHost(playerConverter.toDto(entity.getHost()));
		dto.setCreatedDate(entity.getCreatedDate());
		
		
		
		dto.setCurrentPlayer((entity.getCurrentPlayer()));
		
		List<Token> tokens = tokenRepository.findAllByPlayerGamePrimaryKeyGameId(entity.getId());
		
		List<TokenDto> tokenDtos = tokenConverter.toListDto(tokens);
		
		dto.setTokens(tokenDtos);
		
		List<PlayerGameDto> players = playerGameConverter.toListDto(entity.getPlayerGames());
		dto.setPlayers(players);
		return dto;

	}

	public List<GameDto> toListDto(List<Game> games) {
		List<GameDto> result = new ArrayList<>();
		games.stream().forEach(e -> {
			result.add(toDto(e));
		});
		return result;
	}
}
