package com.masai.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "BillingService")
public class BillServiceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;
	private Integer BillingId;
	private Integer orderId;
	private String TransactionMode;
	private Date TransactionDate;
	private String TransactionStatus;
	@Embedded
	private Address address;

}