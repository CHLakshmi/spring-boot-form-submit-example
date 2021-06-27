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
	private int bill_id;
	
	@Column
    private int student_id;
	
	@Column
	private int bill_amount;
}

