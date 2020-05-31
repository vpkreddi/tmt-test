package com.payment.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.core.domain.PaymentTerm;

@Repository
public interface PaymentTermRepository extends JpaRepository<PaymentTerm, Integer> {
	long deleteByCode(String code);
	Optional<PaymentTerm> findByCode(String code);
}
