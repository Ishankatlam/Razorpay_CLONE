package com.ishanknjr.razorpay.vault.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_token")
public class CardToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column( nullable = false , length = 50 , unique = true )
    private String token;

    @ManyToOne(fetch = FetchType.LAZY , optional = false )
    @JoinColumn(name = "vault_card_id" , nullable = false)
    private vaultCard vaultCard;


    @Column( nullable = false)
    private UUID customer ;


    @Column( nullable = false)
    private UUID merchant ;

    private LocalDateTime expiryDate;


}
