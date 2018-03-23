package com.qinmei.spring2boot;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.qinmei.spring2boot.dao.A2B;
import com.qinmei.spring2boot.dao.UserRepository;
import com.qinmei.spring2boot.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDataJpa {

	@Autowired
	private UserRepository repository;
	
	/**
	 * 测试 repository根据名称生成的方法
	 */
	public void contextLoads() {
		//User user = repository.findByUserName("wzf");
		//User user2 = repository.findByPassWord("333");// 测试按名称查询
		User user3 = repository.findByUserNameOrPassWord("ttt", "22");
		//long l = repository.countByUserName("shf");// 按条件统计某字段
		// List<User> list = repository.findByUserNameLike("%s%"); // 模糊查询
//		List<User> list2 = repository.findByUserNameOrderByIdDesc("shf");// 倒序查询
//		for (User user : list2) {
//			System.out.println(user.getId());
//		}
		Assert.assertEquals("22", user3.getPassWord()); // 断言00
	}
	
	/**
	 * 分页测试
	 */
	public void testPage() {
		int page=0,size=3;// 分页查询，业务层处理参数，第几页，每页显示多少等参数
		Sort sort = new Sort(Direction.DESC, "id");// 通过那个字段排序，一般主键
	    Pageable pageable = new PageRequest(page, size, sort);// 参数封装
	    
	    Page<User> page2 = repository.findByUserName("shf", pageable);// 指定字段查询结果并分页
//	    Page<User> page2 = repository.findAll(pageable); // 包含查询到的数据，数据量与显示多少相等
	    
//		int pages = page2.getTotalPages(); // 总页数  底层通过总条数和每页数量有计算
//		//List<User> list = page2.getContent(); // 获取数据，集合
//		System.out.println(page2.getNumber()); // 页数（第几页）
//		System.out.println(page2.getNumberOfElements()); // 显示多少条
//		System.out.println(page2.getTotalElements()); // 数据总条数 
//		System.out.println(page2.getSort()); // 排序方式
		Assert.assertEquals(2, page2.getTotalPages());
	}
	
	/**
	 * 测试自定义 sql  
	 */
	@Test
	public void testMySQL() {

//		User user = repository.findByEmailAddress("wzf");
//		System.out.println(user);
//		
//		int id = repository.modifyByIdAndUserId(3);
//		System.out.println(id);
//		
//		int i = repository.modifyById("woshini", 6);
//		System.out.println(i);
		
		List<A2B> pages = repository.findByA2B(1); // 多表关联查询
		System.out.println(pages);
	}
	
}
