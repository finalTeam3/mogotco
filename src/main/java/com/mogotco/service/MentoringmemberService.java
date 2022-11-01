package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringmemberMapper;

@Service
public class MentoringmemberService implements MyService<Integer,MentoringmemberDTO>{ 

	@Autowired
	MentoringmemberMapper mapper;

	@Override
	public void register(MentoringmemberDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MentoringmemberDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MentoringmemberDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringmemberDTO> get() throws Exception {
		return mapper.selectAll();
	}

}
