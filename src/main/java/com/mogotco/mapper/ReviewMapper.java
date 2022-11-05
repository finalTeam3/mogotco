package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, ReviewDTO>{
	public List<ReviewDTO> getmentorreview(String userid) throws Exception;
}

