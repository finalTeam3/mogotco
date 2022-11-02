package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringOptionMapper;

@Service
public class MentoringOptionService implements MyService<Integer, MentoringOptionDTO> {
	
	@Autowired
	MentoringOptionMapper mapper;

	@Override
	public void register(MentoringOptionDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MentoringOptionDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MentoringOptionDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringOptionDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
