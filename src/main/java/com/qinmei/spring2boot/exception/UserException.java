package com.qinmei.spring2boot.exception;

import com.qinmei.spring2boot.enums.ResultEnum;

/**
 * 自定义用户异常
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日上午9:13:36
 */
public class UserException extends RuntimeException{

	// 调用父类
    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    // 消息状态
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
