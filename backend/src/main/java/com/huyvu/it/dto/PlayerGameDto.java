package com.huyvu.it.dto;

import java.util.Date;

import com.huyvu.it.models.Color;

import lombok.Data;

@Data
public class PlayerGameDto {
	private Color color;
	private PlayerDto player;
	private Date finishDate;
}
