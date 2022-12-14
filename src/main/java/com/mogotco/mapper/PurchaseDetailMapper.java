package com.mogotco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.frame.MyMapper;



@Repository
@Mapper
public interface PurchaseDetailMapper extends MyMapper<Integer, PurchaseDetailDTO> {
	public List<PurchaseDetailDTO> facedetail(String purchase_userid) throws Exception;
	public List<PurchaseDetailDTO> remotedetail(String purchase_userid) throws Exception;
	public List<PurchaseDetailDTO> wholedetail(String purchase_userid) throws Exception;
	public PurchaseDetailDTO groupcount(Integer mentoringoption_mentoringoptionid) throws Exception;
	
	//멘토링 구매완료한 사람중 오늘 멘토링인 사람들 메일주소
	public List<String> todaymentoringmail() throws Exception;
	//멘토링 구매완료한 사람중 내일 멘토링인 사람들 메일주소
	public List<String> tomorrowmentoringmail() throws Exception;
}
