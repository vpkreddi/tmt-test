package com.invoice.app;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.core.domain.Invoice;
import com.app.core.domain.STATUS;
import com.invoice.domain.repo.InvoiceRepository;
import com.invoice.domain.repo.PaymentTermRepo;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.invoice")
@EntityScan(basePackages = "com.app.core.domain")
@EnableJpaRepositories(basePackages = "com.invoice.domain.repo")
@EnableScheduling
public class InvoiceApplication implements CommandLineRunner {

	@Autowired
	InvoiceRepository invoiceRepo;

	@Autowired
	PaymentTermRepo paymentTermRepo;

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(100);
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setThreadNamePrefix("Async-");
		return executor;
	}

	@Override
	public void run(String... args) throws Exception {
		invoiceRepo.deleteAll();
		Invoice inv = new Invoice("INV-001", Date.valueOf("2020-05-19"), paymentTermRepo.findByCode("NET15").get(),
				STATUS.UNPAID);
		Invoice inv2 = new Invoice("INV-002", Date.valueOf("2020-05-02"), paymentTermRepo.findByCode("NET30").get(),
				STATUS.UNPAID);
		Invoice inv3 = new Invoice("INV-003", Date.valueOf("2020-04-15"), paymentTermRepo.findByCode("NET45").get(),
				STATUS.UNPAID);
		invoiceRepo.save(inv);
		invoiceRepo.save(inv2);
		invoiceRepo.save(inv3);
	}

}
