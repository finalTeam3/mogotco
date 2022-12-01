package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, ReviewDTO>{
	public List<ReviewDTO> getmentorreview(int mentorid) throws Exception;
	
	//개인 mentor 평점 avg(choyunyoung add)
	public ReviewDTO indivirating(int mentorid) throws Exception;
	//mentor전체들의 평점 avg(choyunyoung add)(4명 순서대로)
	public List<ReviewDTO> topmentors() throws Exception;
	//mentor들의 cate뽑기(review에 있음)(choyunyoung add)
	public List<ReviewDTO> mentorwish(int mentorid) throws Exception;
}

