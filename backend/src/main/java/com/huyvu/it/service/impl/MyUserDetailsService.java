package com.huyvu.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.huyvu.it.dto.AuthenticationRequest;
import com.huyvu.it.models.Player;
import com.huyvu.it.repository.PlayerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Player loadUserByUsername(String username) throws UsernameNotFoundException {

		Player player = playerRepository.findOneByUsername(username);

		return player;
	}

	public void register(AuthenticationRequest request) throws Exception {
		Player user = playerRepository.findOneByUsername(request.getUsername());

		if (user != null) {
			throw new Exception("Email has already exist!");
		}

		Player newPlayer = new Player(request.getUsername(), passwordEncoder.encode(request.getPassword()));

		playerRepository.save(newPlayer);

	}

}
