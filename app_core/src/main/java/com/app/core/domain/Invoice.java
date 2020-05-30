package com.app.core.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private @Id String invoiceNum;
	@NotNull
	private Date invoiceDate;

	@OneToOne()
	@JoinColumn(name = "payment_term", referencedColumnName = "code")
	private PaymentTerm paymentTerm;

	@Enumerated(EnumType.STRING)
	@ColumnDefault(value = "UNPAID")
	private STATUS status;

	public Invoice(String invoiceNum, Date invoiceDate, PaymentTerm paymentTerm, STATUS status) {
		super();
		this.invoiceNum = invoiceNum;
		this.invoiceDate = invoiceDate;
		this.paymentTerm = paymentTerm;
		this.status = status;
	}

}
