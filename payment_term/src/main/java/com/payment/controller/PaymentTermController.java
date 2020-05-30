package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.core.domain.PaymentTerm;
import com.payment.service.PaymentTermService;

@RestController
@RequestMapping("/paymentTerm")
public class PaymentTermController {
	
	@Autowired
	PaymentTermService paymentTermSrvc;
	
	@GetMapping(path = "/{code}")
	public ResponseEntity<PaymentTerm> getPaymentTerm(@PathVariable(name = "code") String code) {
		PaymentTerm pt = paymentTermSrvc.getPaymentTerm(code);
		if(pt!=null) {
			return ResponseEntity.ok(pt);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/{code}")
	@Transactional
	public ResponseEntity<String> deletePaymentTerm(@PathVariable(name="code") String code){
		paymentTermSrvc.deletePaymentTerm(code);
		return ResponseEntity.ok("delete success");
	}
	
	
	@PostMapping
	public ResponseEntity<PaymentTerm> createPaymentTerm(@RequestBody PaymentTerm pt){
		PaymentTerm ptObj = paymentTermSrvc.createPaymentTerm(pt);
		if(pt!=null) {
			return ResponseEntity.ok(ptObj);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
