package com.huyvu.it.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
	// identify position in table
	private Color color;
	private int fieldNumber;
	private FieldType fieldtype;

	// indentify the number of home field when being striked
	private int homeFieldnumber;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "game_id"), @JoinColumn(name = "player_id") })
	private PlayerGame playerGame;

	public Token(Color color, int fieldNumber, FieldType fieldtype, int homeFieldnumber, PlayerGame playerGame) {
		this.color = color;
		this.fieldNumber = fieldNumber;
		this.fieldtype = fieldtype;
		this.playerGame = playerGame;
		this.homeFieldnumber = homeFieldnumber;
	}

	public Token(Color color, int fieldNumber, FieldType fieldType) {
		this.color = color;
		this.fieldNumber = fieldNumber;
		this.fieldtype = fieldType;
	}
}
