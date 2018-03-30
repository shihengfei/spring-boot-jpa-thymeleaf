package com.qinmei.spring2boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qinmei.spring2boot.utils.RedisUtil;

/**
 * 测试 redis 
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月30日上午8:09:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisUtil redisUtil;
	
	@Test
	public void testRedis() {
		redisUtil.set("shini", "是我");
		
		System.out.println(redisUtil.get("shini"));
	}
}
