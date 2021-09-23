package com.huyvu.it.models;

import lombok.Data;

@Data
public class GameField {
	private int id;
	private Color color;
	private int radius;
	private int x;
	private int y;
}
