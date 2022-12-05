package com.mogotco.usercoupon;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.UserCouponDTO;
import com.mogotco.service.UserCouponService;

@SpringBootTest
	class UserCouponAll {
	@Autowired
	UserCouponService service;
	
	@Test
	void contextLoads() {
		List<UserCouponDTO> list = null;
		try {
			list = service.userCouponAll("qkrgPwjd1541");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(UserCouponDTO c:list) {
			System.out.println(c);
		}
	}

}
