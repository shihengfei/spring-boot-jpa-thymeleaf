package com.qinmei.spring2boot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 用户实体
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月16日上午9:26:55
 */
@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id // 指定主键
	@GeneratedValue(strategy=GenerationType.AUTO) // 主键生成策略，mysql 默认自增长
	private Integer id;
	
	@Column
	private String userName;
	
	@Column
	private String passWord;
	
	/** fastJson 解析包，将日期格式化 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss ")
	//@JSONField(serialize=false)  是否序列化该字段， false 不返回该数据
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", createTime=" + createTime
				+ "]";
	}
	
}
