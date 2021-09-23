package com.huyvu.it.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	@GetMapping("/dice")
	@CrossOrigin(origins = "http://localhost:8080")
	public ResponseEntity<Integer> getIDiced() {
		int randomNumber =  ThreadLocalRandom.current().nextInt(1, 6 + 1);
		return ResponseEntity.ok(randomNumber);
	}
}
