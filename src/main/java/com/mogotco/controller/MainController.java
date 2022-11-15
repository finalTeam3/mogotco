package com.mogotco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotco.dto.BoardDTO;
import com.mogotco.service.BoardService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	BoardService board_service;
	
	@RequestMapping("")
	public String main() {
		return "main";
	}
	
	//자주 묻는 질문 페이지
	@RequestMapping("/faq")
	public String faq(Model model) {
		List<BoardDTO> board = null;
		try {
			board = board_service.selectboardtype(2);
			model.addAttribute("faq", board);
			model.addAttribute("center", "faq");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//공지사항
	@RequestMapping("/notice")
	public String notice(Model model) {
		List<BoardDTO> board = null;
		try {
			board = board_service.selectboardtype(1);
			model.addAttribute("nt", board);
			model.addAttribute("center", "notice");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	//공지사항 내용
	@RequestMapping("/noticedetail")
	public String noticedetail(Model model, int boardid) {
		BoardDTO board = null;
		try {
			board = board_service.get(boardid);
			model.addAttribute("nt", board);
			model.addAttribute("center", "noticedetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
}
