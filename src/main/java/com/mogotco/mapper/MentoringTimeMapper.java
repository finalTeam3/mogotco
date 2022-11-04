package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringTimeDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringTimeMapper extends MyMapper<Integer, MentoringTimeDTO> {

}
