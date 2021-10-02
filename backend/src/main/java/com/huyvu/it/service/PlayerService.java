package com.huyvu.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.huyvu.it.converter.GameConverter;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Game;
import com.huyvu.it.repository.GameRepository;

@Service
public class PlayerService {
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameConverter gameConverter;
	
	public List<GameDto> findAllGame(){
		List<Game> games = gameRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
		
		List<GameDto> result = gameConverter.toListDto(games);
		
		return result;
	}
}
