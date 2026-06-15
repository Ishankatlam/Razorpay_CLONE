package com.ishanknjr.razorpay.operations;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "DLQ_events")
public class DLQevents{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID merchantid;

    @OneToOne(fetch = FetchType.LAZY)
    private Webhookevent webhookevent;

    @Column(length = 1000)
    private UUID finalerror ;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false , columnDefinition = "jsnob")
    private Map<String , Object> payload;

    private LocalDateTime movedAt;

    private LocalDateTime replayedAt;

}
