package com.danielnamur.javarecruitinghsa.services;

import java.util.List;
import java.util.Optional;

import com.danielnamur.javarecruitinghsa.models.Coupon;

public interface CouponService {
    Optional<List<Coupon>> getValidsCoupons();
}