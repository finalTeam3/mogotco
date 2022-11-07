package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.WishlistDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.WishlistMapper;

@Service
public class WishlistService implements MyService<Integer, WishlistDTO>{

	@Autowired
	WishlistMapper mapper;
	
	@Override
	public void register(WishlistDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(WishlistDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public WishlistDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<WishlistDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<WishlistDTO> wmentor(String userid) throws Exception {
		return mapper.wmentor(userid);
	}	

}
