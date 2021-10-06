package com.huyvu.it.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Player player = playerRepository.findOneByUsername(username);

		User user = new User(player.getUsername(), player.getPassword(), new ArrayList<>());

		return user;
	}

}
