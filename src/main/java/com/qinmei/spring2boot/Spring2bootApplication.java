package com.qinmei.spring2boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Spring2bootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Spring2bootApplication.class, args);
	}

	/**
	 * 实现 SpringBootServletInitializer 方法，找到启动入口
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Spring2bootApplication.class);
	}

}
