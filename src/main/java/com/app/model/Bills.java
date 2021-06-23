package com.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bills")
public class Bills {

	@Id
	@Column
	private int id;
	
	@Column
    private int student_id;
	
	@Column
	private double amount;
}

