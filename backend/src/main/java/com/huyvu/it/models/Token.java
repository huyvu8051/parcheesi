package com.huyvu.it.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {
	@Id
	@GeneratedValue
	private int id;
	private Color color;
	private int fieldNumber;
	private FieldType fieldtype;
	private String identifier;
	private int radius;
	private int x;
	private int y;
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	public Token(Color color, int fieldNumber, FieldType fieldtype, String identifier, int radius, int x, int y, Game game) {
		this.color = color;
		this.fieldNumber = fieldNumber;
		this.fieldtype = fieldtype;
		this.identifier = identifier;
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.game = game;
	}
}
