package com.mogotco.coupon;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.CouponDTO;
import com.mogotco.service.CouponService;

@SpringBootTest
	class GetAllCoupon {
	@Autowired
	CouponService service;
	
	@Test
	void contextLoads() {
		List<CouponDTO> list = null;
		try {
			list = service.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(CouponDTO c:list) {
			System.out.println(c);
		}
	}

}
