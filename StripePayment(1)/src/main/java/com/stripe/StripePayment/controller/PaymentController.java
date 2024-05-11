package com.stripe.StripePayment.controller;

import com.stripe.Stripe;
import com.stripe.StripePayment.dto.PaymentDto;
import com.stripe.StripePayment.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

      @Value("${stripe.apiKey}")
      private String stripeApiKey;

      @Autowired
      private PaymentService paymentService;

      @PostMapping("/create")
      public ResponseEntity<String> createPayment(@RequestBody PaymentDto paymentDto) {

            try {
                  Stripe.apiKey = stripeApiKey;
                  PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                          .setAmount(Long.parseLong(Integer.toString(paymentDto.getAmount())))
                          .setCurrency(paymentDto.getCurrency())
                          .build();

                  PaymentIntent paymentIntent = PaymentIntent.create(params);

                  paymentDto.setStripeToken(paymentIntent.getId());
                  paymentService.createPayment(paymentDto);

                  return ResponseEntity.ok(paymentIntent.getClientSecret());

            } catch (StripeException e) {
                  e.printStackTrace();
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment creation failed.");
            }

      }
}

