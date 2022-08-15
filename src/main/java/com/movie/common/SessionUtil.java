package com.movie.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.movie.vo.UserVO;


public class SessionUtil {
	
	final String sessionName = "currentUser";

	//세션 등록
	public static void setUser(UserVO userVO) {
		userVO.setPwd("");
		RequestContextHolder.getRequestAttributes().setAttribute("currentUser", userVO, RequestAttributes.SCOPE_SESSION);
	}
	
	//세션 제거
	public static void removeUser() {
		RequestContextHolder.getRequestAttributes().removeAttribute("currentUser", RequestAttributes.SCOPE_SESSION);
	}

	//세션 정보
	public static UserVO getCurrentUser() {
		return (UserVO)RequestContextHolder.getRequestAttributes().getAttribute("currentUser", RequestAttributes.SCOPE_SESSION);
	}
	
	public static String getCurrentUserId() {
		return getCurrentUser() == null? "" : getCurrentUser().getUserId();
	}
	
	public static String getCurrentUserName() {
		return getCurrentUser() == null? "" : getCurrentUser().getUserName();
	}
	public static String getCurrentUserOrder() {
		return getCurrentUser() == null? "" : getCurrentUser().getAuth();
	}
	//로그인 여부
	public static Boolean isLogin() {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return false;
		} else {
			if (getCurrentUser() == null) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	//로그인 유저 아이디
	public static String getUserId() {
		String userId = "";
		if(isLogin()) 
			userId = getCurrentUser().getUserId();
		return userId;
	}
	
	//로그인 유저 이름
	public static String getUserName() {
		String userNamem = "";
		if(isLogin()) 
			userNamem = getCurrentUser().getUserName();
		return userNamem;
	}

}
