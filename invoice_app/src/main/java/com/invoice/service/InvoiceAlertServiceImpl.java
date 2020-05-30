package com.invoice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.app.core.domain.Invoice;
import com.app.core.domain.STATUS;
import com.invoice.domain.repo.InvoiceRepository;

@Service
public class InvoiceAlertServiceImpl implements InvoiceAlertService {

	private Logger logger = LoggerFactory.getLogger(InvoiceAlertServiceImpl.class);

	@Autowired
	InvoiceRepository invoiceRepo;

	@Override
	@Scheduled(cron = "${invoice.alert.cron}")
	public void generateReminderForUnpaidInvoices() {
		List<Invoice> unpaidInvoicesList = invoiceRepo.findByStatus(STATUS.UNPAID);
		List<Invoice> unpaidValidInvoiceForReminders = unpaidInvoicesList.stream().filter((inv) -> {
			LocalDate currentDate = LocalDate.now();
			LocalDate dueDate = inv.getInvoiceDate().toLocalDate().plusDays(inv.getPaymentTerm().getDays());
			LocalDate reminderStartDate = dueDate.minusDays(inv.getPaymentTerm().getReminderBeforeDays());
			if ((currentDate.isBefore(dueDate) || currentDate.isEqual(dueDate))
					&& (currentDate.isAfter(reminderStartDate) || currentDate.isEqual(reminderStartDate))) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		if (unpaidValidInvoiceForReminders.size() > 0) {
			unpaidValidInvoiceForReminders.forEach((invoice) -> {
				logger.info("sending reminder for Invoice:" + invoice.getInvoiceNum() + "due on date " + invoice
						.getInvoiceDate().toLocalDate().plusDays(invoice.getPaymentTerm().getDays()).toString());
			});
		} else {
			logger.info("no valid invoices for reminders");
		}

	}
}
