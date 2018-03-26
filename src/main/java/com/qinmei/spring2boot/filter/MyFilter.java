package com.qinmei.spring2boot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

/**
 * 自定义过滤器
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月16日上午9:19:20
 */
@Configuration
public class MyFilter implements Filter{
	public void destroy() {
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 强转
		HttpServletRequest request = (HttpServletRequest) arg0;
		// 处理请求信息,设置统一编码以及登录拦截
		System.out.println(request.getMethod());
		arg2.doFilter(request, arg1);
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
}
