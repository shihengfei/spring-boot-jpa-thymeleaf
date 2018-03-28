package com.qinmei.spring2boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.qinmei.spring2boot.handler.MyInterceptor;

/**
 * 配置自定义拦截器
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月28日上午9:03:03
 */
@Configuration
public class MyWebConfigurerAdapter extends WebMvcConfigurerAdapter{

	/**
	* 拦截器
	* @param registry
	*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // addPathPatterns 用于添加拦截规则
	    // excludePathPatterns 用户排除拦截
	    registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").
	    excludePathPatterns("/login","/toLogin");
	    super.addInterceptors(registry);
	}

	
}
