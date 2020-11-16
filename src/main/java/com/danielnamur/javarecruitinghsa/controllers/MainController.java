package com.danielnamur.javarecruitinghsa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielnamur.javarecruitinghsa.models.CategoryDTO;
import com.danielnamur.javarecruitinghsa.models.Coupon;
import com.danielnamur.javarecruitinghsa.services.CategoryService;
import com.danielnamur.javarecruitinghsa.services.CouponService;

@RestController
public class MainController {
	
	private CategoryService categoryService;
	
	private CouponService couponService;
	
	/*
	  
	 */
	
	@RequestMapping(value = "/api/category/top5", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> top(){
		
		Optional<List<CategoryDTO>> top5 = categoryService.getTopFiveCategories();
		
		if(top5.isPresent()) {
			return ResponseEntity.of(top5);
		}
		
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
	}
	
	@RequestMapping(value = "/api/category/remaining", method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> remaining(){
		
		Optional<List<CategoryDTO>> top5 = categoryService.getRemainingCategories();
		
		if(top5.isPresent()) {
			return ResponseEntity.of(top5);
		}
		
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@RequestMapping(value = "/api/coupon/valids", method = RequestMethod.GET)
	public ResponseEntity<List<Coupon>> valids(){
		
		Optional<List<Coupon>> top = couponService.getValidsCoupons();
		
		if(top.isPresent()) {
			return ResponseEntity.of(top);
		}
		
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

}
