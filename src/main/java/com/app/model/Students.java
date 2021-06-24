package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Students")
public class Students {

	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int amount;
}

