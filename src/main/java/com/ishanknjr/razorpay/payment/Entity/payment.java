package com.ishanknjr.razorpay.payment.Entity;

import com.ishanknjr.razorpay.common.entity.Money;
import com.ishanknjr.razorpay.common.enums.paymentmethods;
import com.ishanknjr.razorpay.common.enums.paymentstatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY , optional = false )
    @JoinColumn(name = "order_id" ,nullable = false  )
            private OrderRecord order;


           @Column(nullable = false)
            private UUID merchantid;

@Embedded
    private Money amount ;

@Column(nullable = false , length = 100)
    private String idempotencykey;

@Enumerated(EnumType.STRING)
@Column(nullable = false , length = 20 )
    private paymentstatus status ;


    @Column(nullable = false)
    private paymentmethods method;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "method_Details" , columnDefinition = "jsonb")
    private Map<String , Object> methoddetails;

    @Column(length = 100)
    private String bankrefrence;

//    private String failurereason;

    @Column(length = 255)
    private String errorcode ;

    private String errorDescription;

    private LocalDateTime authorized;

    private LocalDateTime capturedAt;


    private LocalDateTime failedAt;

    private LocalDateTime refundedAt;

    private LocalDateTime settledAt;


}
