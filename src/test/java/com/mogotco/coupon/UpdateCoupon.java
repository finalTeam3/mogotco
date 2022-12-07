package com.mogotco.coupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.CouponDTO;
import com.mogotco.dto.MCateDTO;
import com.mogotco.service.CouponService;
import com.mogotco.service.MCateService;

@SpringBootTest
	class UpdateCoupon {
	@Autowired
	CouponService service;
	
	@Test
	void contextLoads() {
		CouponDTO coupon = new CouponDTO(3,"테스트쿠우폰",6000);
		try {
			service.modify(coupon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
