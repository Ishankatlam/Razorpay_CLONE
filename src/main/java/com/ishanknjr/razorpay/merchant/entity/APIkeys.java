package com.ishanknjr.razorpay.merchant.entity;

import com.ishanknjr.razorpay.common.entity.BaseEntity;
import com.ishanknjr.razorpay.common.enums.Environment;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "api_key",
        indexes = {
                @Index(name = "idx_api_key_merchant", columnList = "merchant_id"),
                @Index(name = "idx_api_key_merchant_env" , columnList = "merchant_id, environment , enabled" )
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIkeys extends BaseEntity {

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

     @Column( length = 200)
     private String prevoiusKeySecretHash;

     @Enumerated(EnumType.STRING)
     @Column(nullable = false , length = 10)
     private Environment environment ;

     @Column(nullable = false)
     @Builder.Default
     private boolean enabled  = true ;
     @CreationTimestamp
     private LocalDateTime createdAt;
     private LocalDateTime rotatedAt;
     private LocalDateTime gracePeriodExpiresAt;
     private LocalDateTime lastUsedAt;

     @LastModifiedDate
     private LocalDateTime updatedAt;
}
