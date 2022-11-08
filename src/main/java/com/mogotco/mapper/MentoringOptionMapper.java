package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.frame.MyMapper;

@Repository
@Mapper
public interface MentoringOptionMapper extends MyMapper<Integer, MentoringOptionDTO> {
	// 멘토링 옵션 화면출력(시간, 재고 각각) 출력
	public List<MentoringOptionDTO> viewMentorigTime(int mentoringid) throws Exception;
	public List<MentoringOptionDTO> viewMentoringStock(int mentoringid) throws Exception;
	// 멘토링 옵션 화면출력(시간, 재고 함께) 출력 (화면 구성때문에 혹시 몰라서 예비)
	public List<MentoringOptionDTO> viewMentoringOp(int mentoringid) throws Exception;
	

}
