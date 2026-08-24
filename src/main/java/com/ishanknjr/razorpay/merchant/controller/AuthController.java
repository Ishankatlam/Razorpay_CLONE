package com.ishanknjr.razorpay.merchant.controller;

import com.ishanknjr.razorpay.merchant.DTO.request.MerchantSignupRequest;
import com.ishanknjr.razorpay.merchant.DTO.request.Reasponse.MerchantReasponse;
import com.ishanknjr.razorpay.merchant.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MerchantReasponse> signup(
            @RequestBody @Valid MerchantSignupRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authService.signup(request));
    }
}