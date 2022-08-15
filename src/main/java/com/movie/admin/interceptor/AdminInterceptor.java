package com.movie.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.movie.common.BaseUtil;
import com.movie.common.SessionUtil;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

	
	  public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception {
		/* System.out.println("interceptor"); */
	  if(!SessionUtil.isLogin()){
	  if(BaseUtil.isAjax(request)) response.sendError(999); 
	  else
	  response.sendRedirect(request.getContextPath()+"/admin/login");
	  
	  return false;
	  }
	  
	  return true;
	  }
	  
	  @Override 
	  public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		/* System.out.println("Interceptor > postHandle"); */
	  
	  }
	  
	  @Override
	  public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object object, Exception arg3) throws Exception{ 
		/* System.out.println("Interceptor > afterCompletion" ); */
		  }
	 
}
