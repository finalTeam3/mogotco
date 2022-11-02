package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.frame.MyMapper;



@Repository
@Mapper
public interface MentoringmemberMapper extends MyMapper<Integer, MentoringmemberDTO> {

}
