package com.huyvu.it.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Token;

@Component
public class TokenConverter {

	public TokenDto toDto(Token entity) {
		TokenDto dto = new TokenDto();
		dto.setId(entity.getId());
		dto.setColor(entity.getColor());
		dto.setFieldnumber(entity.getFieldNumber());
		dto.setFieldtype(entity.getFieldtype());
		dto.setIdentifier(entity.getIdentifier());
		dto.setRadius(entity.getRadius());
		dto.setX(entity.getX());
		dto.setY(entity.getY());

		return dto;
	}

	public List<TokenDto> toListDto(List<Token> tokens) {
		List<TokenDto> listDto = new ArrayList<>();

		tokens.parallelStream().forEach(element -> {
			listDto.add(toDto(element));
		});

		return listDto;
	}
}
