package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.PurchaseDetailDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.PurchaseDetailMapper;

@Service
public class PurchaseDetailService implements MyService<Integer,PurchaseDetailDTO>{ 

	@Autowired
	PurchaseDetailMapper mapper;

	@Override
	public void register(PurchaseDetailDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(PurchaseDetailDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public PurchaseDetailDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<PurchaseDetailDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<PurchaseDetailDTO> facedetail(String purchase_userid) throws Exception{
		return mapper.facedetail(purchase_userid);
	}
	
	public List<PurchaseDetailDTO> remotedetail(String purchase_userid) throws Exception{
		return mapper.remotedetail(purchase_userid);
	}
	
	public List<PurchaseDetailDTO> wholedetail(String purchase_userid) throws Exception{
		return mapper.wholedetail(purchase_userid);
	}
	
	public PurchaseDetailDTO groupcount(Integer mentoringoption_mentoringoptionid) throws Exception{
		return mapper.groupcount(mentoringoption_mentoringoptionid);
	}
	
	public List<String> todaymentoringmail() throws Exception{
		return mapper.todaymentoringmail();
	}
	
	public List<String> tomorrowmentoringmail() throws Exception{
		return mapper.tomorrowmentoringmail();
	}

}
