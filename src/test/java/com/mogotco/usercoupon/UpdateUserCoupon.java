package com.mogotco.usercoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserCouponDTO;
import com.mogotco.service.UserCouponService;

@SpringBootTest
	class UpdateUserCoupon {
	@Autowired
	UserCouponService service;
	
	@Test
	void contextLoads() {
		UserCouponDTO mcate = new UserCouponDTO(63,"ehdwns8467",4,null,0);
		try {
			service.modify(mcate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
