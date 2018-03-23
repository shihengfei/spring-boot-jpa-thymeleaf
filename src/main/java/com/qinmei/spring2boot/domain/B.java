package com.qinmei.spring2boot.domain;

/**
 * 测试关联查询
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月23日上午10:08:01
 */
public class B {

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "B [id=" + id + ", name=" + name + "]";
	}
	
}
