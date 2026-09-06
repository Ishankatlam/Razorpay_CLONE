package com.ishanknjr.razorpay.payment.Service.PaymentServiceImpl;

import com.ishanknjr.razorpay.common.enums.paymentstatus;
import com.ishanknjr.razorpay.common.exceptions.BusinessViolationException;
import com.ishanknjr.razorpay.common.exceptions.ResourceNotFoundException;
import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.Entity.Payment;
import com.ishanknjr.razorpay.payment.Enums.OrderStatus;
import com.ishanknjr.razorpay.payment.Enums.PaymentStatus;
import com.ishanknjr.razorpay.payment.Gateway.DTO.PaymentRequest;
import com.ishanknjr.razorpay.payment.Gateway.PaymentGatewayRouter;
import com.ishanknjr.razorpay.payment.Mapper.PaymentMapper;
import com.ishanknjr.razorpay.payment.Processor.DTO.PaymentResult;
import com.ishanknjr.razorpay.payment.Repository.OrderRepository;
import com.ishanknjr.razorpay.payment.Repository.PaymentRepository;
import com.ishanknjr.razorpay.payment.Service.PaymentService;
import com.ishanknjr.razorpay.payment.dto.Request.PaymentInitRequestDTO;
import com.ishanknjr.razorpay.payment.dto.Response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
//    private final Payment payment;
    private final PaymentRepository paymentRepository;
    private final PaymentGatewayRouter paymentGatewayRouter;
//    private final PaymentRequest paymentRequest;
    private final PaymentMapper paymentMapper;

    private static PaymentInitRequestDTO getPaymentInitRequestDTO(PaymentInitRequestDTO request) {
        return request;
    }

    private static PaymentInitRequestDTO getRequest(PaymentInitRequestDTO request) {
        return request;
    }

    @Override
    @Transactional
    public PaymentResponse initiate(UUID merchanId, PaymentInitRequestDTO request) {
        OrderRecord orderRecord = orderRepository.findByIdAndMerchantId(request.orderId() , merchanId)
                .orElseThrow(() -> new ResourceNotFoundException("Order" , request.orderId() ));
        if(orderRecord.getOrderStatus() != OrderStatus.CREATED && orderRecord.getOrderStatus() != OrderStatus.ATTEMPTED){
            throw new BusinessViolationException("ORDER_NOT_PAYABLE" , "order cannot accept in Payment status" + orderRecord.getOrderStatus());
        }

        orderRecord.setOrderStatus(OrderStatus.ATTEMPTED);
        orderRecord.setAttempts(orderRecord.getAttempts() + 1);

         Payment payment =  Payment.builder()
                 .order(orderRecord)
                 .merchantid(merchanId)
                 .amount(orderRecord.getAmount())
                 .status(paymentstatus.CREATED)
                 .methoddetails(request.methodDetails())
                 .build();

         payment = paymentRepository.save(payment);

        PaymentRequest paymentRequest = new PaymentRequest(payment.getId() ,
                request.orderId() ,
                merchanId ,
                orderRecord.getAmount() ,
                request.paymentMethod() ,
                request.methodDetails());

      PaymentResult result =  paymentGatewayRouter.initiate(paymentRequest);

        switch (result) {

            case PaymentResult.Pending pending -> {
                payment.setProcessorreference(pending.registrationRef());
            }

            case PaymentResult.Failure failure -> {
                payment.setStatus(paymentstatus.FAILED);
                payment.setErrorcode(failure.errorCode());
                payment.setErrorDescription(failure.errorDescription());
            }
        }

        payment = paymentRepository.save(payment);
        orderRepository.save(orderRecord);
        return paymentMapper.toResponse(payment);
    }
}
