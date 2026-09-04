package com.ishanknjr.razorpay.payment.Repository;

import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.Entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<payment, UUID> {
    List<payment> findByOrder(OrderRecord order);


}
