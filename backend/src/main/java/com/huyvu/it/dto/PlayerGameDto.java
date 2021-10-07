package com.huyvu.it.dto;

import com.huyvu.it.models.Color;

import lombok.Data;

@Data
public class PlayerGameDto {
	private Color color;
	private PlayerDto player;
}
