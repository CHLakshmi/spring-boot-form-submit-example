package com.app.model;

import lombok.Data;

@Data
public class MatchBillResponse {

	private String id;
	private String name;
	private String amount;
	private String billId;
	private String billStudentId;
	private String billAmount;
	private String status;
	
	
}
