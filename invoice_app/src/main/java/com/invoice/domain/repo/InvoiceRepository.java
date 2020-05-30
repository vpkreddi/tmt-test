package com.invoice.domain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.core.domain.Invoice;
import com.app.core.domain.STATUS;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	List<Invoice> findByStatus(STATUS status);
}
