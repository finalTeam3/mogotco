package com.mogotco.coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.CouponDTO;
import com.mogotco.service.CouponService;

@SpringBootTest
	class GetCoupon {
	@Autowired
	CouponService service;
	
	@Test
	void contextLoads() {
		CouponDTO coupon = null;
		try {
			coupon = service.get(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(coupon);
		
	}

}
