package com.mogotco.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mogotco.dto.PurchaseDTO;

import com.mogotco.frame.MyMapper;



@Repository
@Mapper
public interface PurchaseMapper extends MyMapper<Integer, PurchaseDTO> {
	public PurchaseDTO purchasepage(Integer purchaseid) throws Exception;
	public PurchaseDTO purchasefinishpage(Integer purchaseid) throws Exception;
}
