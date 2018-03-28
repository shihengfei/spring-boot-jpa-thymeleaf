package com.qinmei.spring2boot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 监听文件上传异常处理
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月27日下午3:45:48
 */
@ControllerAdvice
public class UploadHandler {

	    @ExceptionHandler(MultipartException.class)
	    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
	        return "result";
	    }
}
