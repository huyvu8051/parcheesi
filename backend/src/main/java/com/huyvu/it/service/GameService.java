package com.huyvu.it.service;

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Player;

public interface GameService {
	GameDto action(TokenDto tokenDto, Player player) throws Exception;

	GameDto dice(Player player) throws Exception;

	GameDto loadGame(GameDto gameDto, Player player) throws Exception;

	GameDto start(GameDto gameDto, Player player) throws Exception;
}
