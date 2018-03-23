package com.qinmei.spring2boot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.qinmei.spring2boot.domain.User;

/**
 * 用户数据访问
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月19日下午5:04:42
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);// 通过 userName 字段查询对象
	User findByPassWord(String passWord);
	User findByUserNameOrPassWord(String userName, String passWord);// 通过多字段查询  使用 Or 或关系, 或者 And 并关系
	long countByUserName(String userName);// 按条件统计某字段
	List<User> findByUserNameLike(String userName);// 通过 userName 字段模糊查询对象集合, 参数=%"被查询字段"%
	List<User> findByUserNameOrderByIdDesc(String userName); // 通过第一个字段查询，获取的结果按 第二个字段排序.Desc 倒叙

	// 分页查询
	Page<User> findAll(Pageable pageable);
	// 条件分页查询
	Page<User> findByUserName(String userName,Pageable pageable);
	
	// 自定义 sql 删除
	@Transactional
	@Modifying // 增删改需要注解,DML 操作必须声明
	@Query("delete from User where id = ?")
	int modifyByIdAndUserId(Integer id);
	
	// 自定义 sql 修改
	@Transactional
	@Modifying
	@Query("update User u set u.userName = ?1 where u.id = ?2") // ? 后的数字代表参数顺序,一一对应
	int modifyById(String userName,Integer id);
	
	// 自定义 sql 查询
	//@Transactional(timeout = 10)  // 事物添加，查询超时设置
	@Query("select u from User u where u.userName = ?1")
	User findByEmailAddress(String userName);
	
	
	// 多表查询
	@Query(value="SELECT a.`name` aname,b.`name` bname FROM a INNER JOIN b ON"
			+ " a.`B_id`=b.`id` WHERE a.`B_id`=? limit 0,1",nativeQuery = true) // nativeQuery = true表示使用原生 sql 查询，不能使用分页插件
	List<A2B> findByA2B(Integer id);
	
	
}
