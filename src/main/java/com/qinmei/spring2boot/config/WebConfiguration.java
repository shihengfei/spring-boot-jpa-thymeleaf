package com.qinmei.spring2boot.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qinmei.spring2boot.filter.MyFilter;

/**
 * 配置过滤器
 * 
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月16日上午9:23:15
 */
@Configuration
public class WebConfiguration {

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		// 过滤器拦截方式
		registration.addUrlPatterns("/.jsp");
		//registration.addInitParameter("paramName", "paramValue");
		//registration.setName("MyFilter");
		//registration.setOrder(1);
		return registration;
	}
}
