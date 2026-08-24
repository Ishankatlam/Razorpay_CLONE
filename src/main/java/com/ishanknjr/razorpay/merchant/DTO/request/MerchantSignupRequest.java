package com.ishanknjr.razorpay.merchant.DTO.request;


import com.ishanknjr.razorpay.common.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MerchantSignupRequest(

        @NotNull(message = "Name should be provided")
         @Size(max = 50 , message = "Name Should not be more than 50 characters long")
        String name ,

        @Email
        @NotNull(message = "Email is required")
        String email,

        @NotNull(message = "password is required")
        @Size(min = 8 , message = "Password should be of 8 characters long ")
        @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$" ,
                message = "Password must contain uppercase, lowercase, digit and special character")
        String password,

        @Size(max = 100 , message = "Businesss name should not be more than 100 characters")
        String businessName,


        BusinessType businessType
) {



}
