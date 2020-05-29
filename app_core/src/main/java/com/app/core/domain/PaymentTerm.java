package com.app.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class PaymentTerm {
	
	
	private @Id @Setter(AccessLevel.PROTECTED) int id;
	private String code;
	private String description;
	private Date creationDate;
	private int days;
	private int reminderBeforeDays;
	

}
