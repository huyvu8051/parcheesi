package com.huyvu.it.dto;

import lombok.Data;

@Data
public class ActionResponseDto {
	private int gameId;
	private TokenDto ally;
	private TokenDto enemy;
}
