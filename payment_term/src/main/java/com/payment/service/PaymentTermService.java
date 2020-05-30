package com.payment.service;

import com.app.core.domain.PaymentTerm;

public interface PaymentTermService {
	
	PaymentTerm createPaymentTerm(PaymentTerm pt) ;
	Long deletePaymentTerm(String code);
	PaymentTerm updatePaymentTerm(PaymentTerm pt);
	PaymentTerm getPaymentTerm(String code);

}
