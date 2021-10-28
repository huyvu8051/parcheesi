package com.huyvu.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.huyvu.it.dto.AuthenticationRequest;
import com.huyvu.it.dto.AuthenticationResponse;
import com.huyvu.it.service.impl.MyUserDetailsService;
import com.huyvu.it.utils.jwtUtil;

@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private jwtUtil jwtUtil;

	@PostMapping("/authentication")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException e) {
			return ResponseEntity.badRequest().body("Username or password uncorrect");
		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getUsername());

		final String jwt = jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUsername()));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			myUserDetailsService.register(request);
			return ResponseEntity.ok().body("Register successful!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
