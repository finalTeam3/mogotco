package com.mogotco.usercoupon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MCateDTO;
import com.mogotco.dto.UserCouponDTO;
import com.mogotco.service.MCateService;
import com.mogotco.service.UserCouponService;

@SpringBootTest
	class InsertUserCoupon {
	@Autowired
	UserCouponService service;
	

	@Test
	void contextLoads() {

		UserCouponDTO ucoupon = new UserCouponDTO(0,"ehdwns8467",3,null,0);
		try {
			service.register(ucoupon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
