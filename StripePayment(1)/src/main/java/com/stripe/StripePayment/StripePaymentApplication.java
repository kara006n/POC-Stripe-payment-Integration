package com.stripe.StripePayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StripePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StripePaymentApplication.class, args);
		System.out.println("Welcome to Application");
	}

}
