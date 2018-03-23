package com.qinmei.spring2boot.config;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
/**
 * 配置 fastJson 框架
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月19日下午3:08:11
 */
@Configuration
public class JsonConfig {

	/**
	 * 通过 Bean 注入 HttpMessageConverters
	 * 
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1.定义 convert 转换消息对象
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

		// 添加 fastJson 的配置信息，是否要格式化返回的 json 数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		// 添加配置信息
		converter.setFastJsonConfig(fastJsonConfig);

		// 返回对象
		HttpMessageConverter<?> converterMessage = converter;
		return new HttpMessageConverters(converterMessage);

	}
}
