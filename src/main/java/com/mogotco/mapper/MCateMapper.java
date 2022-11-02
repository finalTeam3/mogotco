package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MCateDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MCateMapper extends MyMapper<Integer, MCateDTO> {

}
