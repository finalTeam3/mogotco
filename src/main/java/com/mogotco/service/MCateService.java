package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MCateDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MCateMapper;

@Service
public class MCateService implements MyService<Integer, MCateDTO> {
	
	@Autowired
	MCateMapper mapper;

	@Override
	public void register(MCateDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MCateDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MCateDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MCateDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
