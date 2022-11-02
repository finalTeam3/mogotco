package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.AdminDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface AdminMapper extends MyMapper<String, AdminDTO>{

}
