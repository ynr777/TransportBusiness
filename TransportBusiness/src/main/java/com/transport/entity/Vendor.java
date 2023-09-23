package com.transport.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.data.annotation.Id;

@Data
public class Vendor {

	@Id
	private String id;
	private String companyName;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private Long initalDeposit;
	private Timestamp addedDate;
	private Timestamp updatedDate;
	private String addedUser;
	private String updatedUser;
	private boolean activeFlag = true;

}
