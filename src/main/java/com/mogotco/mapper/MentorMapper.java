package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentorDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentorMapper extends MyMapper<Integer, MentorDTO>{
	public MentorDTO mentorAll(Integer k) throws Exception;
}
