package com.huyvu.it.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FinishPointZone {
	public static Token RED = new Token(Color.WHITE, 23, FieldType.WAYPOINT, 1, null);
	public static Token BLUE = new Token(Color.WHITE, 31, FieldType.WAYPOINT, 1, null);
	public static Token GREEN = new Token(Color.WHITE, 7, FieldType.WAYPOINT, 1, null);
	public static Token YELLOW = new Token(Color.WHITE, 15, FieldType.WAYPOINT, 1, null);
}
