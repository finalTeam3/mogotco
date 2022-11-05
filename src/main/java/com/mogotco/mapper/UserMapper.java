package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.UserDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, UserDTO>{
	
	public UserDTO selectMypage(String userid) throws Exception;
	
}

