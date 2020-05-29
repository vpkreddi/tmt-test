package com.invoice.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.core.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
