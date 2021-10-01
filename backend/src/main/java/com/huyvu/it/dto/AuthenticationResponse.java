package com.huyvu.it.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AuthenticationResponse {
	@Getter
	private final String token;

}
