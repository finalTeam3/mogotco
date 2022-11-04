package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringTimeMapper;

@Service
public class MentoringTimeService implements MyService<Integer, MentoringTimeDTO> {
	
	@Autowired
	MentoringTimeMapper mapper;

	@Override
	public void register(MentoringTimeDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MentoringTimeDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MentoringTimeDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringTimeDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
