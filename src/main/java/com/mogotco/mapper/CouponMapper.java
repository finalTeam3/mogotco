package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.CouponDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface CouponMapper extends MyMapper<Integer, CouponDTO> {

}
