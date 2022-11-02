package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentorcardMapper;

@Service
public class MentorcardService implements MyService<Integer, MentorcardDTO>{

	@Autowired
	MentorcardMapper mapper;
	
	@Override
	public void register(MentorcardDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MentorcardDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MentorcardDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentorcardDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
