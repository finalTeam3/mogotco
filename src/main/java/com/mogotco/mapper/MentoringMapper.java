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
	public List<MentoringDTO> viewMentoringAll(Integer meningnum) throws Exception;
	// 등록된 멘토링 리스트 출력을 위한 mapper추가
	public List<MentoringDTO> selectMentoringAll(String mname, Integer meningnum) throws Exception;
	// 멘토링 옵션 출력을 위한 mapper 추가
	public MentoringDTO viewMentoringOp(int mentoringid) throws Exception;
	//지금 당장 롸잇나우 할 수 있는 멘토링
	public List<MentoringDTO> mentoringimmed() throws Exception;
	
	// 멘토링 전체 검색
	public List<MentoringDTO> mentoringsearch(String txt) throws Exception;
	// 멘토링 카테고리별로 검색(choyunyoung add)
	public List<MentoringDTO> mcatesearch(String mname, String txt) throws Exception;
	
	//txt있을 때
	// -- 카테고리, 리뷰순(choyunyoung add)
	public List<MentoringDTO> mcatereviewsearch(String mname, String txt) throws Exception;
	// -- 카테고리, 가격순(choyunyoung add)
	public List<MentoringDTO> mcatepricesearch(String mname, String txt) throws Exception;
	// -- 카테고리, 가장빨리 멘토링 가능한 순(choyunyoung add)
	public List<MentoringDTO> mcaterecentsearch(String mname, String txt) throws Exception;
	// -- 카테고리, 사후관리 유무(choyunyoung add)
	public List<MentoringDTO> mcatemcaringoksearch(String mname, String txt, int mcaring) throws Exception;
	
	// -- 전체 , 가격순(choyunyoung add)
	public List<MentoringDTO> allreviewsearch(String txt) throws Exception;
	// -- 전체 , 리뷰순(choyunyoung add)
	public List<MentoringDTO> allpricesearch(String txt) throws Exception;
	// -- 전체, 가장빨리 멘토링 가능한 순(choyunyoung add)
	public List<MentoringDTO> allrecentsearch(String txt) throws Exception;
	// -- 전체, 사후관리 유무(choyunyoung add)
	public List<MentoringDTO> allmcaringoksearch(String txt, int mcaring) throws Exception;
	
	//txt없을 때
	// -- 카테고리, 리뷰순(choyunyoung add)
	public List<MentoringDTO> nmcatereviewsearch(String mname) throws Exception;
	// -- 카테고리, 가격순(choyunyoung add)
	public List<MentoringDTO> nmcatepricesearch(String mname) throws Exception;
	// -- 카테고리, 가장빨리 멘토링 가능한 순(choyunyoung add)
	public List<MentoringDTO> nmcaterecentsearch(String mname) throws Exception;
	// -- 카테고리, 사후관리 유무(choyunyoung add)
	public List<MentoringDTO> nmcatemcaringoksearch(String mname, int mcaring) throws Exception;
	
	// -- 전체 , 가격순(choyunyoung add)
	public List<MentoringDTO> nallreviewsearch() throws Exception;
	// -- 전체 , 리뷰순(choyunyoung add)
	public List<MentoringDTO> nallpricesearch() throws Exception;
	// -- 전체, 가장빨리 멘토링 가능한 순(choyunyoung add)
	public List<MentoringDTO> nallrecentsearch() throws Exception;
	// -- 전체, 사후관리 유무(choyunyoung add)
	public List<MentoringDTO> nallmcaringoksearch(int mcaring) throws Exception;
}
