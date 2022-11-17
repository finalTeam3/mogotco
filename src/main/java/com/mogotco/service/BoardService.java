package com.mogotco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogotco.dto.BoardDTO;
import com.mogotco.frame.MyService;
import com.mogotco.mapper.BoardMapper;

@Service
public class BoardService implements MyService<Integer, BoardDTO>{
	
	@Autowired
	BoardMapper mapper;

	@Override
	public void register(BoardDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(BoardDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public BoardDTO get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<BoardDTO> get() throws Exception {
		return mapper.selectAll();
	}
	
	public List<BoardDTO> selectboardtype(int boardtype) throws Exception {
		return mapper.selectboardtype(boardtype);
	}
}