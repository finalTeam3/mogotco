package com.mogotco.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.dto.WishlistDTO;
import com.mogotco.service.WishlistService;

@SpringBootTest
class UpdateWishlist {

	@Autowired
	WishlistService service;
	
	@Test
	void contextLoads() {
		WishlistDTO wishlist = new WishlistDTO(904, "user06", 105);
		try {
			service.modify(wishlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

