package com.ishanknjr.razorpay.merchant.Repository;

import com.ishanknjr.razorpay.merchant.entity.APIkeys;

public interface ApiKeyRepository {
    APIkeys save(APIkeys apiKey);
}
