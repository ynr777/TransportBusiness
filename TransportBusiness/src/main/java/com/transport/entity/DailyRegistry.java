package com.transport.entity;

import lombok.Data;

import java.sql.Date;

import org.springframework.data.annotation.Id;

@Data
public class DailyRegistry {

	@Id
	private String id;
	private Date date;
	private String vechileType;
	private String material;
	private String vechilNumber;
	private String advanceAmount;
	private String dieselQty;
	private String dieselQtyAmount;
	private String dieselBunkDetails;
	private String finalAmount;
	private String companyName;
	private String vendorRecived;
	private String employee;

}
