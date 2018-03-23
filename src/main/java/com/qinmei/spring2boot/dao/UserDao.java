package com.qinmei.spring2boot.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qinmei.spring2boot.domain.User;

/**
 * 用户数据查询自定义
 * 
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月21日上午9:00:31
 */
@Repository
public class UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
 
	/**
	 * 条件查询唯一数据
	 * @param id
	 * @return
	 */
	public User queryUserById(Integer id) {
		// 1.书写 sql 语句;
		String sql = "select * from user where id = ?";
		// 2.创建 RowMapper 对象
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		// 3.执行查询
		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
		return user;
	}
	
	/**
	 * 条件查询多个数据
	 * @param userName
	 * @return
	 */
	public List<User> queryUsersByuserName(String userName){
		// 1.书写 sql
		String sql = "select * from user where user_name = ?";
		// 2.创建 RowMapper 对象
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		// 3.执行
		List<User> list = jdbcTemplate.query(sql, new Object[] {userName}, rowMapper);
		return list;
	}

	
	
}
