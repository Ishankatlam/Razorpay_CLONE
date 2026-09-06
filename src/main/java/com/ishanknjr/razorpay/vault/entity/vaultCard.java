package com.ishanknjr.razorpay.vault.entity;

import com.ishanknjr.razorpay.common.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vault_card")
public class vaultCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false , length = 4)
    private String lastfour ;

    @Column(nullable = false , length = 6)
    private String bin ;

    @Column(nullable = false )
    private byte[] encryptedPan;

    @Column(nullable = false )
    private byte[] encryptedDek;

    @Column(nullable = false )
    private String brand ;

    @Column(nullable = false )
    private String Expirymonth;

    @Column(nullable = false )
    private String Expirydate ;

    @Column(nullable = false )
    private String cardholdername ;

//    @Column(nullable = false )
    private LocalDateTime deletedat;

}
