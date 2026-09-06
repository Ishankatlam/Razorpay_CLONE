package com.ishanknjr.razorpay.payment.Controller;

import com.ishanknjr.razorpay.payment.Service.PaymentService;
import com.ishanknjr.razorpay.payment.dto.Request.PaymentInitRequestDTO;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService  paymentService;
    UUID merchanId =  UUID.fromString("9b17b360-8a73-4adc-a586-7f50005f6aaa");

    @PostMapping
    public ResponseEntity<PaymentResponse> initiate( @Valid @RequestBody PaymentInitRequestDTO request) {
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(paymentService.initiate(merchanId , request));
    }
}
