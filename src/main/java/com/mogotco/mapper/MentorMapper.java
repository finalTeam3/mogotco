package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentorDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentorMapper extends MyMapper<Integer, MentorDTO>{
	public MentorDTO mentorAll(String userid) throws Exception;
	public List<MentorDTO> mentoritem(int mentorid) throws Exception;
	public MentorDTO mentoritem1(int mentorid) throws Exception;
	public MentorDTO adminupdate(String userid) throws Exception;
	public MentorDTO mentordetail(int mentorid) throws Exception;
	public List<MentorDTO> mentormentoring(int mentorid) throws Exception;
}
