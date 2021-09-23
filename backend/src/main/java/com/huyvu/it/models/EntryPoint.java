package com.huyvu.it.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EntryPoint {
	BLUE(0), GREEN(8), YELLOW(16), RED(24);

	private Integer value;
}
