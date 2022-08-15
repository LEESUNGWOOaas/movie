package com.movie.front.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.admin.board.service.BoardService;
import com.movie.vo.BoardVO;

@Controller
public class FrontBoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/front/board/list")
	public String list(Model model,BoardVO boardVO)throws Exception{
		
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",boardVO.getPageVO());
		return "";
	}
}
