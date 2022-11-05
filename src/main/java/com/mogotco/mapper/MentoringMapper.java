package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringMapper extends MyMapper<Integer, MentoringDTO> {
	public List<MentoringDTO> selectMentoringAll(int mcateid) throws Exception;

}
