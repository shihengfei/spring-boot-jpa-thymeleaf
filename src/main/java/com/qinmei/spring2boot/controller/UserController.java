package com.qinmei.spring2boot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qinmei.spring2boot.dao.A2B;
import com.qinmei.spring2boot.domain.User;
import com.qinmei.spring2boot.service.UserService;

/**
 * 用户控制器
 * 
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月16日上午8:57:58
 */
@RestController
public class UserController {
	
	// 配置文件值获取
	@Value("${hhha}")
	private String hhh;

	@Autowired
	private UserService userService;
	
	/**
	 * 获取素有用户并分页
	 * @return
	 */
	@GetMapping("/getAllUser")
	public List<User> getUserAll(){
		return userService.getUserAll();
	}
	
	// 保存
	@GetMapping("/saveUser")
	public String saveUser() {
		User user = new User();
		user.setPassWord("111");
		user.setUserName("shf");
		user.setCreateTime(new Date());
		userService.saveUser(user);
		return "success";
	}
	
	@GetMapping("/getuser")
	public Map<String,String> getUser(){
		Map<String,String> map = new HashMap<>();
		map.put("name", "jack");
		map.put("password", hhh);
		return map;
	}
	
	@GetMapping("/getusers")
	public User getUsers() {
		User user = new User();
		user.setPassWord("1230");
		user.setUserName("rose");
		user.setCreateTime(new Date());
		return user;
	}
	
	// 根据 id 查询
	@GetMapping("/getuserbyid")
	public User getUserById(Integer id) {
		return userService.getUserById(id);
	}
	
	// 使用自定义名称
	@GetMapping("/queryUsersByuserName")
	public List<User> queryUsersByuserName(String userName){
		return userService.queryUsersByuserName(userName);
	}
	
	// 多表关联查询
	@GetMapping("/queryUserPage")
	public List<User> queryA2B(){
		return userService.queryUserPage(0,2).getContent();
	}
}
