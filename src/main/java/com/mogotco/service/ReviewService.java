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
	
	public List<ReviewDTO> getmentorreview(String userid) throws Exception {
	      return mapper.getmentorreview(userid);
	}
	
	//개인 mentor 평점 avg(choyunyoung add)
	public ReviewDTO indivirating(String userid) throws Exception{
		return mapper.indivirating(userid);
	}
	//mentor전체들의 평점 avg(choyunyoung add)(4명 순서대로)
	public List<ReviewDTO> topmentors() throws Exception{
		return mapper.topmentors();
	}


}
