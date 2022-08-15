package com.movie.admin.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.admin.board.service.BoardService;
import com.movie.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//메인 Page
	@RequestMapping("/admin/board/list")
	public String list(Model model,BoardVO boardVO)throws Exception{
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",boardVO.getPageVO());
		
		return "board/boardList.admin";
	}
	//상세보기(View page)
	@RequestMapping("/admin/board/{boardNo}")
	public String view(BoardVO boardVO,Model model)throws Exception{
		boardVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO",boardVO);
		
		return "board/boardView.admin";
	}
	//등록 page
	@RequestMapping("/admin/board/form")
	public String form(BoardVO boardVO,Model model)throws Exception{
		boardVO = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO",boardVO);
		return "board/boardForm.admin";
	}
	// 등록 
	@ResponseBody
	@RequestMapping("/admin/board/save")
	public Map<String, Object> save(BoardVO boardVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.insert(boardVO);
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","성공했습니다.");
		}else{
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
	//삭제
	@ResponseBody
	@RequestMapping("/admin/board/delete")
	public Map<String, Object> delete(BoardVO boardVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.delete(boardVO);
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","성공했습니다.");
		}else{
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
}
