package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MWishcateMapper;

@Service
public class MWishcateService implements MyService<Integer, MWishcateDTO>{

	@Autowired
	MWishcateMapper mapper;

	@Override
	public void register(MWishcateDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MWishcateDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MWishcateDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MWishcateDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	

}
