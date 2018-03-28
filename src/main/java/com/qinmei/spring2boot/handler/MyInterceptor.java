package com.qinmei.spring2boot.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器，处理用户登录问题
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月28日上午8:49:30
 */
public class MyInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;
		if(null == request.getSession().getAttribute("shf")) {
			// 重定向到登录界面
			response.sendRedirect("login");
			flag = false;
		}else {
			flag = true;
		}
		return flag;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}
}
