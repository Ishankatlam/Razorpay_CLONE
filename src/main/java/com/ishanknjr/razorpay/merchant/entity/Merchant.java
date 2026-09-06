package com.ishanknjr.razorpay.merchant.entity;

import com.ishanknjr.razorpay.common.enums.BusinessType;
import com.ishanknjr.razorpay.common.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "merchant",
        indexes = {@Index( name = "idx_merchant_status" , columnList =  "status")

}
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// all these annotations are coming from the lombok
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column(nullable = false , length = 200)
      private String name ;

    @Column(nullable = false , unique = true )
      private String email;

    @Column( length = 20)
      private String contactnumber;

@Column( length = 20)
@Enumerated(EnumType.ORDINAL)
    public BusinessType bussinessType;


    @Column( length = 50)
      private String bussinessname;

    @Column(length = 200)
      private String websiteurl;

    @Column(nullable = false , length = 200)
//    @Builder.Default
    @Enumerated(EnumType.STRING)
      private MerchantStatus status = MerchantStatus.PENDING_KYC;

    @Column(length = 20)
      private String gstid;

    @Column( length = 20)
      private String panId ;


    @Column( length = 20)
      private String settlementBankAccount ;

     @Column( length = 20)
      private String settlementBankIfsc;

     @Column( length = 20)
      private String settlementbankHolderName;



}
