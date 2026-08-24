package com.ishanknjr.razorpay.merchant.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook"  )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class merchantwebhookconfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "merchant_id" , nullable = false)
    private Merchant merchant;

    @Column(nullable = false , length = 500)
    private String targeturl; // www.zara.com/webhook

    @Column( length = 255)
    private String webhookscrethash;

    @Column(nullable = false )
    private boolean enabled = true ;
    
    @Column(length = 255)
    private String eventtypes ;





}
