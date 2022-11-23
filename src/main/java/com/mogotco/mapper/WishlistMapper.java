package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface WishlistMapper extends MyMapper<Integer, WishlistDTO>{
	public List<WishlistDTO> wmentor(String userid) throws Exception;
	public WishlistDTO wishcheck(String userid, Integer mentorid) throws Exception;
}
