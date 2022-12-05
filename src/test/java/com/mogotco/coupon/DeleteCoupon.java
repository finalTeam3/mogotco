package com.mogotco.coupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.CouponService;

@SpringBootTest
	class DeleteCoupon {
	
	@Autowired
	CouponService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
