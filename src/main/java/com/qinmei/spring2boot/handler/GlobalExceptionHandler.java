package com.qinmei.spring2boot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinmei.spring2boot.domain.Result;
import com.qinmei.spring2boot.exception.UserException;
import com.qinmei.spring2boot.utils.ResultUtil;

/**
 * 统一异常处理
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日上午8:59:42
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 统一异常拦截，指定 runtime异常拦截处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=RuntimeException.class) // 拦截指定异常
	@ResponseBody // 返回 json 格式
	public Result exceptionHandler(Exception e){
		 // 判断是否为自定义异常
        if (e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());
        }else {
            // 捕获后处理,系统运行时错误，非自定义
            return ResultUtil.error(1, "未知错误");
        }
	}
	
}
