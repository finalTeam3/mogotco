package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.CouponDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.CouponMapper;

@Service
public class CouponService implements MyService<Integer, CouponDTO> {
	
	@Autowired
	CouponMapper mapper;

	@Override
	public void register(CouponDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(CouponDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public CouponDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CouponDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
