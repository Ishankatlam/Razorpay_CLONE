package com.ishanknjr.razorpay.common.enums;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

public enum orderstatus {
    CREATED,
    ATTEMPTED,
    PAID,
    CANCELED,
}

