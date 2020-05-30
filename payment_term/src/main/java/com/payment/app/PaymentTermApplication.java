package com.payment.app;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.core.domain.PaymentTerm;
import com.payment.domain.repo.PaymentTermRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.payment")
@EntityScan(basePackages = "com.app.core.domain")
@EnableJpaRepositories(basePackages = "com.payment.domain.repo")
@EnableTransactionManagement
public class PaymentTermApplication implements CommandLineRunner {
	
	@Autowired
	PaymentTermRepository paymentTermRepo;

	public static void main(String[] args) {
		SpringApplication.run(PaymentTermApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 paymentTermRepo.deleteAll();
	 PaymentTerm pt = new PaymentTerm("NET15", "15 DAYS", new Date(System.currentTimeMillis()), 15, 3);
	 PaymentTerm pt1 = new PaymentTerm("NET30", "30 DAYS", new Date(System.currentTimeMillis()), 30, 4);
	 PaymentTerm pt2 = new PaymentTerm("NET45", "45 DAYS", new Date(System.currentTimeMillis()), 45, 5);
	 paymentTermRepo.save(pt);
	 paymentTermRepo.save(pt1);
	 paymentTermRepo.save(pt2);
	}

}
