package com.mogotco.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserCouponDTO {
	private int usercouponid;
	private String userid;
	private int couponid;
	
	// 쿠폰 이벤트를 위한 dto추가
	private String coupon_couponname;
	private int coupon_couponprice;
}
