package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.PlayerDto;
import com.huyvu.it.models.Game;

@Component
public class GameConverter {

	@Autowired
	private TokenConverter tokenConverter;

	@Autowired
	private PlayerConverter playerConverter;

	public GameDto toDto(Game entity) {
		GameDto dto = new GameDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setDiceValue(entity.getDiceValue());
		dto.setDiced(entity.isDiced());
		dto.setTokens(tokenConverter.toListDto(entity.getTokens()));
		dto.setHost(playerConverter.toDto(entity.getHost()));
		dto.setCreatedDate(entity.getCreatedDate());
		List<PlayerDto> players = playerConverter.toListDto(entity.getPlayerGames());
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
