package com.huyvu.it.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corundumstudio.socketio.SocketIOServer;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.service.impl.HostService;
import com.huyvu.it.service.impl.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	private HostService hostService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private SocketIOServer server;

	@GetMapping("/game")
	public List<GameDto> getAllRoom() {
		try {
			return playerService.findAllGame();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@PostMapping("/game")
	public ResponseEntity<Object> createNewGame(@RequestBody GameDto gameDto) {

		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return ResponseEntity.ok(
					hostService.createGame(gameDto, player));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PostMapping("/join")
	public ResponseEntity<Object> join(@RequestBody GameDto gameDto) {

		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GameDto response = playerService.join(gameDto, player);
			server.getRoomOperations(String.valueOf(response.getId())).sendEvent("join", response);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
