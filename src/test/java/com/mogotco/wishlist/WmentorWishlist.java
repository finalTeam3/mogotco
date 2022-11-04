package com.mogotco.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.service.WishlistService;

@SpringBootTest
class WmentorWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		WishlistDTO wishlist = null;
		try {
			wishlist = service.wmentor("rlaaudgml4321");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(wishlist);
	}

}
