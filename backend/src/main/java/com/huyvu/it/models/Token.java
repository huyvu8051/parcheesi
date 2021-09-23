package com.huyvu.it.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Token {
	@Id
	private int id;
	private Color color;
	private int fieldNumber;
	private FieldType fieldType;
	private String identifier;
	private int radius;
	private int x;
	private int y;
}
