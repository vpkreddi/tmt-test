package com.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.core.domain.PaymentTerm;
import com.payment.domain.repo.PaymentTermRepository;

@Service
@Transactional
public class PaymentTermServiceImpl implements PaymentTermService {
	
	@Autowired
	PaymentTermRepository paymentTermRepo;
	
	@Override
	
	public PaymentTerm createPaymentTerm(PaymentTerm pt) {
		// TODO Auto-generated method stub
		return paymentTermRepo.save(pt);
	}

	@Override
	public boolean deletePaymentTerm(String code) {
		// TODO Auto-generated method stub
		return paymentTermRepo.deleteByCode(code)>0 ? true: false;
	}

	@Override
	public PaymentTerm updatePaymentTerm(PaymentTerm pt) {
		// TODO Auto-generated method stub
		return paymentTermRepo.save(pt);
	}

	@Override
	public Optional<PaymentTerm> getPaymentTerm(String code) {
		// TODO Auto-generated method stub
		return paymentTermRepo.findByCode(code);
	}

}
