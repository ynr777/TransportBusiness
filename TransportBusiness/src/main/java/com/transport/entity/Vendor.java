package com.transport.entity;

import lombok.Data;

import java.util.List;

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

}
