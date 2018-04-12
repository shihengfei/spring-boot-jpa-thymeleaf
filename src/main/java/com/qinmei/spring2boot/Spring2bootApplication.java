package com.qinmei.spring2boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 开启定时任务
@EnableCaching //开启缓存
@SpringBootApplication
public class Spring2bootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Spring2bootApplication.class, args);
	}

	/**
	 * 继承 SpringBootServletInitializer 方法，找到启动入口,打包 war
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Spring2bootApplication.class);
	}
	
}
