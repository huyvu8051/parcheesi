package com.huyvu.it.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.service.HostService;
import com.huyvu.it.service.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private HostService hostService;

	@Autowired
	private PlayerService playerService;

	@GetMapping("/game")
	public List<GameDto> getAllRoom() {
		try {
			return playerService.findAllGame();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@PostMapping("/game")
	public ResponseEntity<GameDto> createNewGame(@RequestBody GameDto gameDto) {

		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			return ResponseEntity.ok(
					hostService.createGame(gameDto, new Player(userDetails.getUsername(), userDetails.getPassword())));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}

	}
}
