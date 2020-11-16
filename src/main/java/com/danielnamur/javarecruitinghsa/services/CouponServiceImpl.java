package com.danielnamur.javarecruitinghsa.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.danielnamur.javarecruitinghsa.converters.CouponConverter;
import com.danielnamur.javarecruitinghsa.models.Coupon;
import com.danielnamur.javarecruitinghsa.repositories.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	CouponRepository couponRepo;
	
	CouponConverter couponConverter;
	
	@Override
	public Optional<List<Coupon>> getValidsCoupons() {
		try {
			
			return Optional.ofNullable(couponConverter.deleteExpired(couponRepo.findCouponList()));
			
		} catch (ParseException exception) {
			
			return Optional.empty();
		}
	}

}
