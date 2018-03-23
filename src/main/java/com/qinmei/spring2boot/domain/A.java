package com.qinmei.spring2boot.domain;

/*8
 * 测试关联查询
 */
public class A {

	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private Integer bId;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + ", age=" + age + ", bId=" + bId + "]";
	}
	
}
