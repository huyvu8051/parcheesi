package com.huyvu.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huyvu.it.models.Player;
import com.huyvu.it.repository.PlayerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player loadUserByUsername(String username) throws UsernameNotFoundException {

		Player player = playerRepository.findOneByUsername(username);

		return player;
	}

}
