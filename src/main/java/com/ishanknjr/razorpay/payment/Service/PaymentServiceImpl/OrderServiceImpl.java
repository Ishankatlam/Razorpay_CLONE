package com.ishanknjr.razorpay.payment.Service.PaymentServiceImpl;

import com.ishanknjr.razorpay.common.exceptions.DuplicateResourceException;
import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.Enums.OrderStatus;
import com.ishanknjr.razorpay.payment.Repository.OrderRepository;
import com.ishanknjr.razorpay.payment.Service.OrderService;
import com.ishanknjr.razorpay.payment.dto.Request.CreateOrderRequest;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Value("${payment.order.default-order-expiry-minutes : 30}")
     private int defaultOrderExterminates;

//    @Override
//    public OrderResponse create(CreateOrderRequest request) {
//        return null;
//    }

    @Override
    public OrderResponse create(UUID merchantId, CreateOrderRequest request) {

        if (request.receipt() != null
                && orderRepository.existsByMerchantIdAndReceipt(
                merchantId,
                request.receipt()
        )) {

            throw new DuplicateResourceException(
                    "ORDER_RECEIPT_DUPLICATE",
                    "Order with receipt already exists: " + request.receipt()
            );
        }

        OrderRecord  orderRecord =  OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())
                .merchantId(merchantId)
                .orderStatus(OrderStatus.CREATED)
                .expiresAt(request.expiresAt() != null ? request.expiresAt() : LocalDateTime.now().plusMinutes(defaultOrderExterminates))
                .createdAt(LocalDateTime.now())
                .build();

//     TODO:   send kafka event that kafka is created

        orderRecord = orderRepository.save(orderRecord);
        return new OrderResponse(orderRecord.getId()
                , orderRecord.getMerchantId()
                , orderRecord.getReceipt()
                , orderRecord.getAmount() , orderRecord.getOrderStatus()
                , orderRecord.getAttempts() , orderRecord.getNotes()
                ,orderRecord.getExpiresAt() ,  null );

    }
}

