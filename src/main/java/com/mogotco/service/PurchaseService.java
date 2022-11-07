package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.PurchaseDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.PurchaseMapper;

@Service
public class PurchaseService implements MyService<Integer,PurchaseDTO>{ 

	@Autowired
	PurchaseMapper mapper;

	@Override
	public void register(PurchaseDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(PurchaseDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public PurchaseDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<PurchaseDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public PurchaseDTO purchasepage(Integer purchaseid) throws Exception{
		return mapper.purchasepage(purchaseid);
	}

	public PurchaseDTO purchasefinishpage(Integer purchaseid) throws Exception{
		return mapper.purchasefinishpage(purchaseid);
	}
}
