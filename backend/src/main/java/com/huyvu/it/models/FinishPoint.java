package com.huyvu.it.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class FinishPoint {
	@Id
	private int id;
	private String name;
}
