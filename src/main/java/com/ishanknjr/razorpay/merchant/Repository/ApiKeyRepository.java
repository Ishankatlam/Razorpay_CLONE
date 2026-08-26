package com.ishanknjr.razorpay.merchant.Repository;

import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.ApiKeyResponse;
import com.ishanknjr.razorpay.merchant.entity.APIkeys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<APIkeys, UUID> {
    APIkeys save(APIkeys apiKey);

    List<APIkeys> findByMerchant_Id(UUID merchantId);
}
