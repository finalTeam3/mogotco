package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringMapper extends MyMapper<Integer, MentoringDTO> {

}
