package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringMapper;

@Service
public class MentoringService implements MyService<Integer, MentoringDTO> {
	
	@Autowired
	MentoringMapper mapper;

	@Override
	public void register(MentoringDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MentoringDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MentoringDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<MentoringDTO> selectMentoringAll(int mcateid) throws Exception {
		return mapper.selectMentoringAll(mcateid);
	}

}
