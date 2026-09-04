package com.ishanknjr.razorpay.payment.Repository;

import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.dto.Response.OrderResponse;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderRecord, UUID> {

    Optional<OrderRecord> findByIdAndMerchantId(UUID orderId, UUID merchantId) ;

    boolean existsByMerchantIdAndReceipt(UUID merchantId, @Size(max = 100)String receipt);
}
