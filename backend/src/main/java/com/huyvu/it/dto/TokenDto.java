package com.huyvu.it.dto;

import com.huyvu.it.models.Color;
import com.huyvu.it.models.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
	private int id;
	private Color color;
	private int fieldnumber;
	private FieldType fieldtype;
	private Color identifier;
	private int radius;
	private int x;
	private int y;
}
