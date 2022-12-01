package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.dto.MentoringmemberDTO;
import com.mogotco.frame.MyMapper;



@Repository
@Mapper
public interface MentoringmemberMapper extends MyMapper<Integer, MentoringmemberDTO> {

	// 멘토링 옵션id로 멘토링 멤버의 userid 가져올 때(mentoringmemeber 페이지)
	public List<MentoringmemberDTO> mmemberuserid(int mentoringoptionid) throws Exception;
	
}
