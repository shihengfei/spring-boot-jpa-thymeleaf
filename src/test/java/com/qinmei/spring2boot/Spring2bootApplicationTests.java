package com.qinmei.spring2boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qinmei.spring2boot.dao.UserRepository;
import com.qinmei.spring2boot.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring2bootApplicationTests {
	
	@Autowired
	private UserRepository repository;

	@Test
	public void contextLoads() {
		
		User user = new User();
		user.setPassWord("123");
		user.setUserName("shf");
		
		User user2 = repository.save(user);
		// 断言
		Assert.assertEquals("shf", user2.getUserName());
		
	}

}
