package com.huyvu.it.dto;

import java.util.Date;
import java.util.List;

import com.huyvu.it.models.Color;
import com.huyvu.it.models.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
	private int id;
	private String name;
	private Status status;
	private int diceValue;
	private boolean isDiced;
	private PlayerDto host;
	private Date createdDate;
	
	private Color currentPlayer;

	private List<PlayerGameDto> players;

	private List<TokenDto> tokens;

}
