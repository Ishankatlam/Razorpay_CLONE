package com.ishanknjr.razorpay.merchant.entity;

import com.ishanknjr.razorpay.common.enums.Environment;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "api_key")
public class APIkeys {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

     @ManyToOne(fetch = FetchType.LAZY , optional = false)
     @JoinColumn(name = "merchant_id" , nullable = false)
     private Merchant merchant;

     @Column(nullable = false , length = 50)
     private String keyId;

     @Column(nullable = false , length = 200)
     private String keySecretHash;

     @Enumerated(EnumType.STRING)
     @Column(nullable = false , length = 10)
     private Environment environment ;

     @Column(nullable = false)
     private boolean enabled  = true ;
     private java.time.LocalDateTime createdAt;
     private java.time.LocalDateTime rotatedAt;
     private java.time.LocalDateTime gracePeriodExpiresAt;

}
