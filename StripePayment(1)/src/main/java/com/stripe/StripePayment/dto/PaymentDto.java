package com.stripe.StripePayment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
      private String stripeToken;
      private Integer amount;
      private String currency;

      // Getters and setters
}

