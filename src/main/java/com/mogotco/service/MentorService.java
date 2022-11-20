package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentorDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentorMapper;

@Service
public class MentorService implements MyService<Integer, MentorDTO> {

	@Autowired
	MentorMapper mapper;
	
	@Override
	public void register(MentorDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(MentorDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public MentorDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentorDTO> get() throws Exception {
		return mapper.selectAll();
	}

	public MentorDTO mentorAll(String userid) throws Exception {
		return mapper.mentorAll(userid);
	}

	public List<MentorDTO> mentoritem(int mentorid) throws Exception {
		return mapper.mentoritem(mentorid);
	}

	public MentorDTO adminupdate(String userid) throws Exception {
		return mapper.adminupdate(userid);
	}
	
	public MentorDTO mentordetail(int mentorid) throws Exception{
		return mapper.mentordetail(mentorid);
	}

}
