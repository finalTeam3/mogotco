package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.MentoringOptionDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.MentoringOptionMapper;

@Service
public class MentoringOptionService implements MyService<Integer, MentoringOptionDTO> {
	
	@Autowired
	MentoringOptionMapper mapper;

	@Override
	public void register(MentoringOptionDTO v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(MentoringOptionDTO v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public MentoringOptionDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<MentoringOptionDTO> get() throws Exception {
		return mapper.selectAll();
	}
	// 멘토링 옵션 화면출력(시간) 출력
	public List<MentoringOptionDTO> viewMentorigTime(int mentoringid) throws Exception {
		return mapper.viewMentorigTime(mentoringid);
		
	}
	// 멘토링 옵션 화면출력(재고) 출력
	public List<MentoringOptionDTO> viewMentoringStock(int mentoringid) throws Exception {
		return mapper.viewMentoringStock(mentoringid);
	}
	// 멘토링 옵션 화면출력(시간, 재고 함께) 출력 (화면 구성때문에 혹시 몰라서 예비)
	public List<MentoringOptionDTO> viewMentoringOp(int mentoringid) throws Exception {
		return mapper.viewMentoringOp(mentoringid);
	}

}
