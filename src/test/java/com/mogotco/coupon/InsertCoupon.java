package com.mogotco.coupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.CouponDTO;
import com.mogotco.dto.MCateDTO;
import com.mogotco.service.CouponService;

@SpringBootTest
	class InsertCoupon {
	@Autowired
	CouponService service;
	

	@Test
	void contextLoads() {

		CouponDTO coupon = new CouponDTO(3,"테스트쿠폰",5000);
		try {
			service.register(coupon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
