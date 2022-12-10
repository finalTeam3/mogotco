package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.UserCouponDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface UserCouponMapper extends MyMapper<Integer, UserCouponDTO> {
	public List<UserCouponDTO> userCouponAll(String userid) throws Exception;
	public UserCouponDTO userCouponfind(String userid, int willusecoupon) throws Exception;
}
