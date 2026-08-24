package com.ishanknjr.razorpay.operations;

import com.ishanknjr.razorpay.common.enums.webhookeventstatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "webhook_event")
public class Webhookevent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false )
    private UUID merchantid;

    @Column(nullable = false  , length = 100)
    private String eventType ;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String , Object> payload;


    @Column(nullable = false )
    private String targeturl;

   @Column(nullable = false )
    private String signature ;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false )
    private webhookeventstatus status ;


    @Column(nullable = false )
    private Integer attempts =0;


    private LocalDateTime nextretryat ;

    private LocalDateTime lastattemptAt;

    @Column(length = 1000)
    private String lastreasponsebody;

    private LocalDateTime delivered ;







}
