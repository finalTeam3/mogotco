package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface WishlistMapper extends MyMapper<Integer, WishlistDTO>{
	public WishlistDTO wmentor(String userid) throws Exception;
}
