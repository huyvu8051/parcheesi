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

import com.huyvu.it.dto.GameDto;
import com.huyvu.it.dto.MoveDto;
import com.huyvu.it.service.GameService;

@RestController
public class PlayerController {
	@Autowired
	private GameService gameService;
	@GetMapping("/dice")
	public ResponseEntity<Object> getIDiced() {
		try {
			
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			GameDto gameDto = gameService.dice(userDetails);
			return ResponseEntity.ok(gameDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PostMapping("/action")
	public ResponseEntity<Object> move(@RequestBody MoveDto moveDto){
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			MoveDto response = gameService.action(moveDto, userDetails);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
}
