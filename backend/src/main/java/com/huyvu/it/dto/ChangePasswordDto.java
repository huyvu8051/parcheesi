package com.huyvu.it.dto;

import lombok.Data;

@Data
public class ChangePasswordDto {
	private String oldPassword;
	private String password;
}
