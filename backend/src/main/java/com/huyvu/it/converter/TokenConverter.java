package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.it.dto.PlayerGameDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Token;

@Component
public class TokenConverter {
	@Autowired
	private PlayerGameConverter playerGameConverter;
	
	public TokenDto toDto(Token entity) {
		TokenDto dto = new TokenDto();
		dto.setId(entity.getId());
		dto.setColor(entity.getColor());
		dto.setFieldnumber(entity.getFieldNumber());
		dto.setFieldtype(entity.getFieldtype());
		
		PlayerGameDto playerGameDto = playerGameConverter.toDto(entity.getPlayerGame());
		
		dto.setPlayerGame(playerGameDto);
		return dto;
	}

	public List<TokenDto> toListDto(List<Token> tokens) {
		List<TokenDto> listDto = new ArrayList<>();

		tokens.stream().forEach(element -> {
			listDto.add(toDto(element));
		});

		return listDto;
	}
}
