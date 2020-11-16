package com.danielnamur.javarecruitinghsa.repositories;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.danielnamur.javarecruitinghsa.models.Coupon;

@Service
public class CouponRepository {

    RestTemplateBuilder builder;

    public Coupon[] findCouponList() {
        String url = "https://cs-hsa-api-coupons.herokuapp.com/coupons";
        Coupon[] body = builder
                .setConnectTimeout(Duration.ofSeconds(10l))
                .build()
                .getForEntity(url,
                        Coupon[].class)
                .getBody();
        return body;
    }
}