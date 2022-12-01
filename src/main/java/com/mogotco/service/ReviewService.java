package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.ReviewDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.ReviewMapper;

@Service
public class ReviewService implements MyService<Integer, ReviewDTO>{
	
	@Autowired
	ReviewMapper mapper;

	@Override
	public void register(ReviewDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(ReviewDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public ReviewDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<ReviewDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<ReviewDTO> getmentorreview(int mentorid) throws Exception {
	      return mapper.getmentorreview(mentorid);
	}
	
	//개인 mentor 평점 avg(choyunyoung add)
	public ReviewDTO indivirating(int mentorid) throws Exception{
		return mapper.indivirating(mentorid);
	}
	//mentor전체들의 평점 avg(choyunyoung add)(4명 순서대로)
	public List<ReviewDTO> topmentors() throws Exception{
		return mapper.topmentors();
	}
	//mentor들의 cate뽑기(review에 있음)(choyunyoung add)
	public List<ReviewDTO>mentorwish(int mentorid) throws Exception{
		return mapper.mentorwish(mentorid);
	}


}
