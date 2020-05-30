package com.invoice.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.core.domain.PaymentTerm;

@Repository
public interface PaymentTermRepo extends JpaRepository<PaymentTerm, Integer> {
	
	Optional<PaymentTerm> findByCode(String code);

}
