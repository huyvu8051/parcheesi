package com.huyvu.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.huyvu.it.dto.ChangePasswordDto;
import com.huyvu.it.models.Player;
import com.huyvu.it.repository.PlayerRepository;

@Service
public class AccountService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private PlayerRepository playerRepository;

	public void changePassword(ChangePasswordDto dto, Player player) throws Exception {

		String oldPassword = player.getPassword();

		boolean notMatches = !passwordEncoder.matches(dto.getOldPassword(), oldPassword);

		if (notMatches) {
			throw new Exception("Old password incorrect!");
		}

		player.setPassword(passwordEncoder.encode(dto.getPassword()));

		playerRepository.save(player);

	}

}
