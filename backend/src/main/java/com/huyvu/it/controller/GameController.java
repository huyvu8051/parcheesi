package com.huyvu.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corundumstudio.socketio.SocketIOServer;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.TokenDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.service.GameService;

@RestController
public class GameController {
	@Autowired
	private GameService gameService;
	
	@Autowired
	private SocketIOServer server;

	@GetMapping("/dice")
	public ResponseEntity<Object> dice() {
		try {

			Player player = (Player) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto gameDto = gameService.dice(player);
			
			server.getRoomOperations(String.valueOf(gameDto.getId())).sendEvent("dice", gameDto);
			
			return ResponseEntity.ok(gameDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/parcheesi")
	public ResponseEntity<Object> loadGame(@RequestBody GameDto gameDto) {
		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto response = gameService.loadGame(gameDto, player);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@PostMapping("/action")
	public ResponseEntity<Object> action(@RequestBody TokenDto token) throws Exception {
		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto response = gameService.action(token, player);
			server.getRoomOperations(String.valueOf(response.getId())).sendEvent("action", response);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	@PostMapping("/start")
	public ResponseEntity<Object> start(@RequestBody GameDto gameDto) {
		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto response = gameService.start(gameDto, player);
			server.getRoomOperations(String.valueOf(response.getId())).sendEvent("startGame", response);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
	
}
