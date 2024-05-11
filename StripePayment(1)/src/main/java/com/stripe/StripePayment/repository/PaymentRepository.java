package com.stripe.StripePayment.repository;

import com.stripe.StripePayment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

