package com.ishanknjr.razorpay.payment.Entity;

import com.ishanknjr.razorpay.common.enums.paymentactor;
import com.ishanknjr.razorpay.common.enums.paymentevent;
import com.ishanknjr.razorpay.common.enums.paymentstatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Table(name = "payment_transition_log" ,
       indexes = {@Index(name = "idx_payment_transition_log_payment_id" , columnList = "payment_id")}
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class paymenttransition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "payment_id" , nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status" , length = 30)
    private paymentstatus fromstatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "event" , nullable = false , length = 30)
    private paymentevent event ;


    @Enumerated(EnumType.STRING)
    @Column(name = "to_status" , nullable = false , length = 30)
    private paymentstatus tostatus;

    @Column(length = 100 , name = "actor")
    private paymentactor actor ;


    @Column(name = "occured_at" , nullable = false)
    private LocalDateTime occuredAt;

}
