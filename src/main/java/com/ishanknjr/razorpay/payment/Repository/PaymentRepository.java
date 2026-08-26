package com.ishanknjr.razorpay.payment.Repository;

import com.ishanknjr.razorpay.payment.Entity.OrderRecord;
import com.ishanknjr.razorpay.payment.Entity.payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<payment, UUID> {
}
