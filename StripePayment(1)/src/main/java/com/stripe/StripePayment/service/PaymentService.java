package com.stripe.StripePayment.service;

import com.stripe.StripePayment.dto.PaymentDto;
import com.stripe.StripePayment.entity.Payment;
import com.stripe.StripePayment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

      @Autowired
      private PaymentRepository paymentRepository;

      public Payment createPayment(PaymentDto paymentDto) {
            Payment payment = new Payment();
            payment.setStripeToken(paymentDto.getStripeToken());
            payment.setAmount(paymentDto.getAmount());
            payment.setCurrency(paymentDto.getCurrency());
            return paymentRepository.save(payment);
      }
}

