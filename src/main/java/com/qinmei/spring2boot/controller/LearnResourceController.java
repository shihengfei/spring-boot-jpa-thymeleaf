package com.qinmei.spring2boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qinmei.spring2boot.domain.LearnResouce;
import com.qinmei.spring2boot.domain.User;

/**
 * 测试 thymeleaf 的使用，对应页面
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月23日上午10:01:36
 */
@Controller
@RequestMapping("/lear")
public class LearnResourceController {
   
	@RequestMapping("/")
    public ModelAndView index(){
        List<LearnResouce> learnList =new ArrayList<LearnResouce>();
        LearnResouce bean =new LearnResouce("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new LearnResouce("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new LearnResouce("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new LearnResouce("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new LearnResouce("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new LearnResouce("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", learnList);
        
        List<String> learnL =new ArrayList<String>();
        learnL.add("test");
        
        modelAndView.addObject("learnL",learnL);
        return modelAndView;
    }
	
	@GetMapping("/test")// 返回类型为 ModelAndView
	public ModelAndView getTest() {
		User user = new User();
		user.setUserName("shf");
		user.setPassWord("123");
		User user2 = new User();
		user2.setUserName("wzf");
		user2.setPassWord("321");
		// 集合类型数据
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		// 创建对象， test 为返回的模板名，有对应的 test.html
		ModelAndView mav = new ModelAndView("test");
		// 集合类型，（变量名，集合）
		mav.addObject("userList", userList);
		return mav;
	}
	
	@GetMapping("/testUser")// 返回类型为 ModelAndView
	public ModelAndView getUsersss() {
		// 单一对象
		User user2 = new User();
		user2.setUserName("shf");
		user2.setPassWord("123");
		// 创建对象， test 为返回的模板名，有对应的 test.html
		ModelAndView mav = new ModelAndView("test");
		// 对象
		mav.addObject(user2);
		return mav;
	}
	
	@GetMapping("/testU")// 返回类型为 ModelAndView
	public ModelAndView getU() {
		//  集合
		Map<String , String> map = new HashMap<>();
		map.put("aaa", "testtt");
		map.put("bbb", "kanjianwo");
		// 创建对象， test 为返回的模板名，有对应的 test.html
		ModelAndView mav = new ModelAndView("test");
		// map 集合
		mav.addAllObjects(map);
		return mav;
	}
	
	@GetMapping("/testList")// 返回类型为 ModelAndView
	public ModelAndView getList() {
		//  集合
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		// 创建对象， test 为返回的模板名，有对应的 test.html
		ModelAndView mav = new ModelAndView("test");
		// map 集合
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/testfreemarker")
	public String getfreemarker() {
		return "testFtl";
	}
}
