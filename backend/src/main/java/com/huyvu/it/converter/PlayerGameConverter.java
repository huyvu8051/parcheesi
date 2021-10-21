package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

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
		dto.setFinishDate(entity.getFinishDate());
		return dto;
	}
	public List<PlayerGameDto> toListDto(List<PlayerGame> entities){
		List<PlayerGameDto> dtos = new ArrayList<>();
		entities.stream().forEach(e->{
			dtos.add(toDto(e));
		});
		
		return dtos;
	}
}
