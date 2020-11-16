package com.danielnamur.javarecruitinghsa.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.danielnamur.javarecruitinghsa.models.Coupon;

@Component
public class CouponConverter {

	public List<Coupon> deleteExpired(Coupon[] coupons) throws ParseException {
		
		List<Coupon> result = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		for(Coupon coupon : coupons) {
			Date expiresAt = format.parse(coupon.getExpiresAt());
			Date today = new Date();
			
			if(today.compareTo(expiresAt) <= 0) {
				result.add(coupon);
			}
		}
		
		return result;
	}
}
