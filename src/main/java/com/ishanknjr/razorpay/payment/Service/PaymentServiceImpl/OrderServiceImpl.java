package com.ishanknjr.razorpay.payment.Service.PaymentServiceImpl;

import com.ishanknjr.razorpay.common.exceptions.BusinessViolationException;
import com.ishanknjr.razorpay.common.exceptions.DuplicateResourceException;
import com.ishanknjr.razorpay.common.exceptions.ResourceNotFoundException;
import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.Entity.payment;
import com.ishanknjr.razorpay.payment.Enums.OrderStatus;
import com.ishanknjr.razorpay.payment.Mapper.OrderMapper;
import com.ishanknjr.razorpay.payment.Mapper.PaymentMapper;
import com.ishanknjr.razorpay.payment.Repository.OrderRepository;
import com.ishanknjr.razorpay.payment.Repository.PaymentRepository;
import com.ishanknjr.razorpay.payment.Service.OrderService;
import com.ishanknjr.razorpay.payment.dto.Request.CreateOrderRequest;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true )
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
   private final PaymentMapper paymentMapper;
   private final OrderMapper orderMapper;
    @Value("${payment.order.default-order-expiry-minutes : 30}")
     private int defaultOrderExterminates;

    @Override
    @Transactional
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

    @Override
    public OrderResponse getById(UUID merchantId, UUID orderId) {


        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId , merchantId)
                .orElseThrow(()-> new ResourceNotFoundException("Order" , orderId));
                return orderMapper.toResponseOrder(order);
    }

    @Override
    @Transactional
    public OrderResponse cancel(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId , merchantId)
                .orElseThrow(()-> new ResourceNotFoundException("Order" , orderId));
        if(order.getOrderStatus()== OrderStatus.CANCELLED || order.getOrderStatus() == OrderStatus.PAID)
        {
          throw new BusinessViolationException("ORDER_CANNOT_CANCELL" , "cannot cancell order with status" + order.getOrderStatus().name());
        }
        order.setOrderStatus(OrderStatus.CANCELLED);
       order = orderRepository.save(order);
        return orderMapper.toResponseOrder(order);
    }

    @Override
    public List<PaymentResponse> listPayments(UUID merchantId, UUID orderId) {
      OrderRecord order =  orderRepository.findByIdAndMerchantId(orderId , merchantId)
                .orElseThrow(()-> new ResourceNotFoundException("Order" , orderId));

        List<payment> paymentList = paymentRepository.findByOrder(order);
        return paymentMapper.toResponseList(paymentList);

    }


    }


