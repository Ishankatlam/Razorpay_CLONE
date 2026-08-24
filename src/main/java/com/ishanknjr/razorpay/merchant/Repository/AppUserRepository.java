package com.ishanknjr.razorpay.merchant.Repository;

import com.ishanknjr.razorpay.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser , UUID> {

    
}
