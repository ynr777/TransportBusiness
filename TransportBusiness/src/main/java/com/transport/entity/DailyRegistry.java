package com.transport.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;

@Data
public class DailyRegistry {

	@Id
	private String id;
	private Long registryId;
	@Transient
	private String isoDate;
	private LocalDateTime invoiceDate;
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
	@CreatedDate
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime updatedDate;
	private String addedUser;
	private String updatedUser;
	private boolean activeFlag = true;

}
