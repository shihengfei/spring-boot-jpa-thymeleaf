package com.qinmei.spring2boot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 文件上传控制器
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月27日下午2:37:37
 */
@Controller
public class PageController {

	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 文件上传
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/upload") 
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes) {
		// 设置返回视图
		ModelAndView mav = new ModelAndView();
	    if (file.isEmpty()) {
	        redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	        mav.setViewName("result");
	        return mav;
	    }
	    try {
	    	// 获取文件字节码
	        byte[] bytes = file.getBytes();
	        // 指定文件保存路径
	        Path path = Paths.get("D:\\" + file.getOriginalFilename());
	        // 保存文件
	        Files.write(path, bytes);
	        mav.addObject("message",
	                "You successfully uploaded '" + file.getOriginalFilename() + "'");
	        mav.setViewName("result");
	        return mav;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return mav;
	}
}
