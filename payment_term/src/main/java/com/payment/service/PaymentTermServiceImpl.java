package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.core.domain.PaymentTerm;
import com.payment.domain.repo.PaymentTermRepository;

@Service
public class PaymentTermServiceImpl implements PaymentTermService {
	
	@Autowired
	PaymentTermRepository paymentTermRepo;
	
	@Override
	public PaymentTerm createPaymentTerm(PaymentTerm pt) {
		// TODO Auto-generated method stub
		return paymentTermRepo.save(pt);
	}

	@Override
	public Long deletePaymentTerm(String code) {
		// TODO Auto-generated method stub
		return paymentTermRepo.deleteByCode(code);
	}

	@Override
	public PaymentTerm updatePaymentTerm(PaymentTerm pt) {
		// TODO Auto-generated method stub
		return paymentTermRepo.save(pt);
	}

	@Override
	public PaymentTerm getPaymentTerm(String code) {
		// TODO Auto-generated method stub
		return paymentTermRepo.findByCode(code);
	}

}
