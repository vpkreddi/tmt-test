package com.app.core.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Invoice {
	
	private @Id @Setter(AccessLevel.PROTECTED)String invoiceNum;
	private Date invoiceDate;
	private String paymentTerm;
	private String status;
	
}
