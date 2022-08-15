package com.movie.admin.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.admin.user.service.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	@RequestMapping({"/admin"})
	public String before(HttpServletRequest request,Model model) throws Exception{
		request.getSession().getAttribute("auth");
		model.addAttribute("request",request);
		return "redirect:/admin/index";
	}
	
	@RequestMapping("/admin/index")
	public String index(HttpServletRequest request,Model model)throws Exception{
		return "redirect:/admin/board/list";
	}
}
