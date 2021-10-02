package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.huyvu.it.dto.PlayerDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.models.PlayerGame;

@Component
public class PlayerConverter {
	public PlayerDto toDto(Player entity) {
		PlayerDto dto = new PlayerDto();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		
		return dto;
	}

	public List<PlayerDto> toListDto(List<PlayerGame> playerGames) {
		List<PlayerDto> dtos = new ArrayList<>();
		
		playerGames.stream().forEach(e->{
			dtos.add(toDto(e.getPlayer()));
		});
		
		return dtos;
	}
}
