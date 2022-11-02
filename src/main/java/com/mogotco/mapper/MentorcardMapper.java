package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentorcardDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentorcardMapper extends MyMapper<Integer, MentorcardDTO>{

}
