package com.movie.admin.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.admin.user.service.UserService;
import com.movie.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/admin/user/list")
	public String list(UserVO userVO, Model model) throws Exception {
		List<UserVO> list = userService.selectUserList(userVO);
		model.addAttribute("list", list);
		model.addAttribute("pageVO", userVO.getPageVO());

		return "user/userList.admin";
	}

	@RequestMapping("/admin/user/{userNo}")
	public String view(UserVO userVO, Model model) throws Exception {
		userVO = userService.selectUser(userVO);
		model.addAttribute("userVO", userVO);

		return "user/userView.admin";
	}

	@RequestMapping("/admin/user/form")
	public String form(UserVO userVO, Model model) throws Exception {
		userVO = userService.selectUser(userVO);
		model.addAttribute("userVO", userVO);

		return "user/userForm.admin";
	}

	@ResponseBody
	@RequestMapping("/admin/user/save")
	public Map<String, Object> save(UserVO userVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = userService.insert(userVO);
		if (result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","성공했습니다");
		} else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/admin/user/delete")
	public Map<String, Object> delete(UserVO userVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = userService.delete(userVO);
		if (result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","성공했습니다");
		} else {
			resultMap.put("result",false);
			resultMap.put("msg","Error");
		}
		return resultMap;
	}
}
