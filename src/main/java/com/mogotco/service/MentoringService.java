package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringMapper;

@Service
public class MentoringService implements MyService<Integer, MentoringDTO> {
	
	@Autowired
	MentoringMapper mapper;

	@Override
	public void register(MentoringDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MentoringDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MentoringDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringDTO> get() throws Exception {
		return mapper.selectAll();
	}
	// 등록된 모든 멘토링을 출력하기 위한 service추가
	public List<MentoringDTO> viewMentoringAll() throws Exception{
		return mapper.viewMentoringAll();
	}
	
	// 등록된 멘토링의 리스트 출력을 위한 service추가
	public List<MentoringDTO> selectMentoringAll(String mname) throws Exception {
		return mapper.selectMentoringAll(mname);
	}
	// 멘토링 옵션 출력을 위한 service 추가
	public MentoringDTO viewMentoringOp(int mentoringid) throws Exception {
		return mapper.viewMentoringOp(mentoringid);
	}
	
	//지금 당장 롸잇나우 할 수 있는 멘토링
	public List<MentoringDTO> mentoringimmed() throws Exception{
		return mapper.mentoringimmed();
	}

}
