package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.mogotco.dto.MWishcateDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MWishcateMapper extends MyMapper<Integer, MWishcateDTO>{
	public List<MWishcateDTO> mwcate(int mentorid) throws Exception;
	public List<MWishcateDTO> mwcatelist(String mname) throws Exception;
}
