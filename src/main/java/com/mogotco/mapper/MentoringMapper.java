package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringMapper extends MyMapper<Integer, MentoringDTO> {
	// 등록된 모든 멘토링을 출력하기 위한 mapper추가
	public List<MentoringDTO> viewMentoringAll() throws Exception;
	// 등록된 멘토링 리스트 출력을 위한 mapper추가
	public List<MentoringDTO> selectMentoringAll(int mcateid) throws Exception;
	// 멘토링 옵션 출력을 위한 mapper 추가
	public MentoringDTO viewMentoringOp(int mentoringid) throws Exception;
	//지금 당장 롸잇나우 할 수 있는 멘토링
	public List<MentoringDTO> mentoringimmed() throws Exception;
	// 멘토링 검색
	public List<MentoringDTO> mentoringsearch(String txt) throws Exception;

}
