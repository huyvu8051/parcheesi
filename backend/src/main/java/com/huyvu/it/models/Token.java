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

	// identify the number of home field when start
	private int homeFieldnumber;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "player_id"), @JoinColumn(name = "game_id") })
	private PlayerGame playerGame;

	public Token(Color color, int fieldNumber, FieldType fieldtype, int homeFieldnumber, PlayerGame playerGame) {
		this.color = color;
		this.fieldNumber = fieldNumber;
		this.fieldtype = fieldtype;
		this.playerGame = playerGame;
		this.homeFieldnumber = homeFieldnumber;
	}
	
	public Token(Color color, int fieldNumber, FieldType fieldtype) {
		this.color = color;
		this.fieldNumber = fieldNumber;
		this.fieldtype = fieldtype;
	}

	/**
	 * Clone
	 * 
	 * @param token
	 */
	public Token(Token token) {
		this.color = token.color;
		this.fieldNumber = token.fieldNumber;
		this.fieldtype = token.getFieldtype();
		this.homeFieldnumber = token.homeFieldnumber;
	}

	/**
	 * compare color, field number and field type
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		Token token = (Token) obj;
		return (this.color.equals(token.getColor()) && this.fieldNumber == token.fieldNumber
				&& this.fieldtype.equals(token.getFieldtype()));
	}
}
