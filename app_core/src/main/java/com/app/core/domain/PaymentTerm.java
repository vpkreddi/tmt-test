package com.app.core.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class PaymentTerm implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Setter(AccessLevel.PROTECTED) int id;
	@NotNull
	private String code;
	private String description;
	@NotNull
	private Date creationDate;
	@NotNull
	private int days;
	@NotNull
	private int reminderBeforeDays;
	
	
	private static final long serialVersionUID = 1L;
	
	public PaymentTerm(String code, String description, Date creationDate, int days, int reminderBeforeDays) {
		super();
		this.code = code;
		this.description = description;
		this.creationDate = creationDate;
		this.days = days;
		this.reminderBeforeDays = reminderBeforeDays;
	}
	
	

}
