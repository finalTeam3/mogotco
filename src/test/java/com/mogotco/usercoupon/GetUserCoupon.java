package com.mogotco.usercoupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserCouponDTO;
import com.mogotco.service.UserCouponService;

@SpringBootTest
	class GetUserCoupon {
	@Autowired
	UserCouponService service;
	
	@Test
	void contextLoads() {
		UserCouponDTO ucoupon = null;
		try {
			ucoupon = service.get(62);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ucoupon);
		
	}

}
