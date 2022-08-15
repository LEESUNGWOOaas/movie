package com.movie.admin.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.common.SessionUtil;
import com.movie.common.SHA256Util;
import com.movie.admin.user.service.UserService;
import com.movie.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/admin/login")
	public String login(Model model)throws Exception{
		if(SessionUtil.isLogin())return "redirect:admin/index";
		return "admin/login/login";
	}
	
	@RequestMapping("/admin/logout")
	public String logout(Model model) throws Exception{
		if(SessionUtil.isLogin())
			SessionUtil.removeUser();
		return "redirect:/admin/login";
	}
	
	
	
	  @ResponseBody
	  @RequestMapping(value="/admin/login", method= RequestMethod.POST)
	  public Map<String, Object> logic(Model model,UserVO memberVO,HttpSession session)throws Exception {
		  Map<String ,Object> resultMap = new HashMap<String, Object>();
			
		  
		  UserVO userVO = userService.selectUserById(memberVO.getUserId());
		  if(userVO==null||
				  !userVO.getDeleteYn().equals("N")||
				  !SHA256Util.getEncrypt(memberVO.getPwd(),userVO.getSalt()).equals(userVO.getPwd())) {
					
				System.out.println("id : " + memberVO.getUserId());
				System.out.println("pwd : " + memberVO.getPwd());
			 System.out.println("pwd : " + memberVO.getPwd());
				  resultMap.put("result",false);
				  resultMap.put("msg","잘못된 정보입니다.");
				}else {
					SessionUtil.setUser(userVO);
					System.out.println("로그인 성공");
					
					 resultMap.put("result",true); 
					 resultMap.put("redirectUrl", "/admin/index");
					 
				}
			return resultMap;
				
	}
}
