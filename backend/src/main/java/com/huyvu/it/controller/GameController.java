package com.huyvu.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.corundumstudio.socketio.SocketIOServer;
import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.TokenDto;
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

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto gameDto = gameService.dice(userDetails);
			
			server.getRoomOperations(String.valueOf(gameDto.getId())).sendEvent("dice", gameDto);
			
			return ResponseEntity.ok(gameDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/parcheesi")
	public ResponseEntity<Object> loadGame(@RequestBody GameDto gameDto) {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto response = gameService.loadGame(gameDto, userDetails);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@PostMapping("/action")
	public ResponseEntity<Object> action(@RequestBody TokenDto token) {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto response = gameService.action(token, userDetails);
			server.getRoomOperations(String.valueOf(response.getId())).sendEvent("action", response);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
}
