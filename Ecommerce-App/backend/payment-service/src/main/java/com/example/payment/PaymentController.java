package com.example.payment;

import com.example.common.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/process")
    public String processPayment(@RequestBody PaymentRequest paymentRequest) {
        return "Payment of " + paymentRequest.getAmount() + " processed for order " + paymentRequest.getOrderId();
    }
}
