package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringOptionMapper extends MyMapper<Integer, MentoringOptionDTO> {

}
