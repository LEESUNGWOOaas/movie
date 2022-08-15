package com.movie.front.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.admin.board.service.BoardService;
import com.movie.admin.user.service.UserService;
import com.movie.util.service.MovieService;
import com.movie.vo.BoardVO;
import com.movie.vo.MovieVO;
import com.movie.vo.UserVO;

@Controller
public class FrontMainController {
	@Autowired
	UserService userService;
	@Autowired
	BoardService boardService;
	@Autowired
	MovieService movieService;
	
	@RequestMapping({"/front","","/"})
	public String index()throws Exception{
		return "redirect:/front/main";
	}
	@RequestMapping("/front/main")
	public String main(BoardVO boardVO,UserVO userVO,MovieVO movieVO,Model model)throws Exception {
		
		int result = movieService.getMovieInfo();
		/*String.valueOf 는 toString 과 마찬가지로 Object 값을 String 형으로 변환시키지만 null결과시
		  toString은  nullpointException을 발생하지만 valueOf는 null을 문자열"null"로 출력한다.*/
		model.addAttribute("result",String.valueOf(result));
		
		movieVO.setListSize(1);
		
		
		return  "front/main";
	}
}
