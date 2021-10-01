package com.huyvu.it.dto;

import java.util.List;

import com.huyvu.it.models.Player;
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
	private Player host;

	// private List<PlayerGame> playerGames;
	
	private List<TokenDto> tokens;

}
