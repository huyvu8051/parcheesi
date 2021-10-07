package com.huyvu.it.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.it.dto.PlayerGameDto;
import com.huyvu.it.models.PlayerGame;

@Component
public class PlayerGameConverter {
	
	@Autowired
	private PlayerConverter playerConverter; 
	
	public PlayerGameDto toDto(PlayerGame entity) {
		PlayerGameDto dto = new PlayerGameDto();
		dto.setColor(entity.getColor());
		dto.setPlayer(playerConverter.toDto(entity.getPlayer()));
		return dto;
	}
}
