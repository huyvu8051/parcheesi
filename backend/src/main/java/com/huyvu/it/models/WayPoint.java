package com.huyvu.it.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class WayPoint {
	@Id
	private int id;
	private Color color; 
	private int fieldNumber;
	private FieldType fieldType;
	
	private String indentifier;
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
}
