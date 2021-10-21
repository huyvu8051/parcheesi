package com.example.demo.service.impl;

public interface SecurityService {
	boolean isAuthenticated();

	void autoLogin(String username, String password);
}
