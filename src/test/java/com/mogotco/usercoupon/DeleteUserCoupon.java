package com.mogotco.usercoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.service.UserCouponService;

@SpringBootTest
	class DeleteUserCoupon {
	
	@Autowired
	UserCouponService service;
	
	@Test
	void contextLoads() {
		try {
			service.remove(63);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
