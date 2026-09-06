package com.ishanknjr.razorpay.merchant.entity;

import com.ishanknjr.razorpay.common.entity.BaseEntity;
import com.ishanknjr.razorpay.common.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "app_user" ,
     indexes = {
        @Index(name = "idx_customer_merchant_id" , columnList = "merchant_id"),
     @Index(name = "idx_customer_email" ,columnList = "email")}
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id" , nullable = false)
    private Merchant merchant;

    @Column(unique = true , nullable = false )
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;





}
