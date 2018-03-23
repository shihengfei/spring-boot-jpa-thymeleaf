package com.qinmei.spring2boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qinmei.spring2boot.dao.UserDao;
import com.qinmei.spring2boot.dao.UserRepository;
import com.qinmei.spring2boot.domain.User;

/**
 * 用户业务
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月19日下午4:49:39
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 分页查询用户列表
	 * @return
	 */
	public Page<User> queryUserPage(int page,int size){
		
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		
		return repository.findAll(pageable);
	}
	
	/**
	 * 总记录查询
	 */
	public Long queryCount() {
		return repository.count();
	}
	
	
	
	/**
	 * 保存用户
	 * @param user
	 */
	@Transactional
	public void saveUser(User user) {
		repository.save(user);
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	@Transactional
	public void deleteUser(Integer id) {
		repository.delete(id);
	}

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> getUserAll(){
		List<User> findAll = repository.findAll();
		return findAll;
	}
	
	/**
	 * 自定义查询
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) {
		return userDao.queryUserById(id);
	}
	
	/**
	 * 条件查询多个数据
	 * @param userName
	 * @return
	 */
	public List<User> queryUsersByuserName(String userName){
		return userDao.queryUsersByuserName(userName);
	}
	
}
