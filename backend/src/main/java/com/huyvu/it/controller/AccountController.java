package com.huyvu.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huyvu.it.dto.ChangePasswordDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.service.impl.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("changePassword")
	public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordDto dto){
		try {
			Player player = (Player) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			accountService.changePassword(dto, player);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
