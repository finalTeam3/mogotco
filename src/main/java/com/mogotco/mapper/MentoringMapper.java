package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringMapper extends MyMapper<Integer, MentoringDTO> {
	// 등록된 멘토링 리스트 출력을 위한 mapper추가
	public List<MentoringDTO> selectMentoringAll(int mcateid) throws Exception;
	// 멘토링 옵션 출력을 위한 mapper 추가
	public List<MentoringDTO> viewMentoringOp(int mentoringid) throws Exception;

}
