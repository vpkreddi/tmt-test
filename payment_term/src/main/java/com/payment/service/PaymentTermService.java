package com.payment.service;

import java.util.Optional;

import com.app.core.domain.PaymentTerm;

public interface PaymentTermService {
	
	PaymentTerm createPaymentTerm(PaymentTerm pt) ;
	boolean deletePaymentTerm(String code);
	PaymentTerm updatePaymentTerm(PaymentTerm pt);
	Optional<PaymentTerm> getPaymentTerm(String code);

}
