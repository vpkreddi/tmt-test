package com.payment.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.core.domain.PaymentTerm;

public interface PaymentTermRepository extends JpaRepository<PaymentTerm, Integer> {

}
