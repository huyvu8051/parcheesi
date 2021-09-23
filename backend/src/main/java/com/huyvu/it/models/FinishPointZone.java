package com.huyvu.it.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FinishPointZone {
	BLUE(31), GREEN(7), YELLOW(15), RED(23);

	private Integer value;
}
