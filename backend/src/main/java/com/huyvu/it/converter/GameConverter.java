package com.huyvu.it.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Game;

@Component
public class GameConverter {

	@Autowired
	private TokenConverter tokenConverter;

	public GameDto toCreateGameDto(Game entity) {
		GameDto dto = new GameDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setDiceValue(entity.getDiceValue());
		dto.setDiced(entity.isDiced());
		dto.setTokens(tokenConverter.toListDto(entity.getTokens()));

		return dto;

	}
}
