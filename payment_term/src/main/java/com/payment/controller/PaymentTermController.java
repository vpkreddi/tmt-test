package com.payment.controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Optional<PaymentTerm> pt = paymentTermSrvc.getPaymentTerm(code);
		if(pt.isPresent()) {
			return ResponseEntity.ok(pt.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/{code}")
	public ResponseEntity<String> deletePaymentTerm(@PathVariable(name="code") String code){
		boolean delRes = paymentTermSrvc.deletePaymentTerm(code);
		return delRes? ResponseEntity.ok("delete success"):ResponseEntity.noContent().build();
	}
	
	
	@PostMapping
	public ResponseEntity<PaymentTerm> createPaymentTerm(@RequestBody PaymentTerm pt){
		if(pt.getCreationDate()==null) {
			pt.setCreationDate(new Date(System.currentTimeMillis()));
		}
		PaymentTerm ptObj = paymentTermSrvc.createPaymentTerm(pt);
		if(ptObj!=null) {
			return ResponseEntity.ok(ptObj);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@PutMapping(path="/{code}")
	public ResponseEntity<PaymentTerm> updatePaymentTerm(@PathVariable(name="code") String code, @RequestBody PaymentTerm pt){
		Optional<PaymentTerm> ptObj = paymentTermSrvc.getPaymentTerm(code);
		if(ptObj.isPresent()) {
		ptObj.get();
		ptObj.get().setCreationDate(pt.getCreationDate());
		ptObj.get().setDays(pt.getDays());
		ptObj.get().setDescription(pt.getDescription());
		ptObj.get().setReminderBeforeDays(pt.getReminderBeforeDays());
		PaymentTerm pterm = paymentTermSrvc.updatePaymentTerm(ptObj.get());
		return ResponseEntity.ok(pterm);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
