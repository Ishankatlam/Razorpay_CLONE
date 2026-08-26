package com.ishanknjr.razorpay.payment.Controller;

import com.ishanknjr.razorpay.payment.Service.OrderService;
import com.ishanknjr.razorpay.payment.dto.Request.CreateOrderRequest;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;
    private final UUID merchantId = UUID.fromString("9b17b360-8a73-4adc-a586-7f50005f6aaa"); //todo which we have to replace with context

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid  CreateOrderRequest request) {
      return ResponseEntity.status(HttpStatus.CREATED)
              .body(orderService.create(merchantId , request));
    }
}
