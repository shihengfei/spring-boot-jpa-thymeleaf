package com.qinmei.spring2boot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class UploadController {

	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	/**
	 * 文件上传
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/upload") 
	
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
	                               RedirectAttributes redirectAttributes,@RequestParam("sort") String sort) {
		// 设置返回视图
		ModelAndView mav = new ModelAndView();
	    if (file.isEmpty()) {
	        redirectAttributes.addFlashAttribute("message", "请选择一个文件");
	        mav.setViewName("result");
	        return mav;
	    }
	    try {
	    	 SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	    	// 获取文件字节码
	        byte[] bytes = file.getBytes();
	        String uploadFilePath = "/home/shf/shffile/"+sort+"/" +myFmt.format(new Date())+file.getOriginalFilename();
	        // 指定文件保存路径
	        Path path = Paths.get(uploadFilePath);
	        // 保存文件
	        Files.write(path, bytes);
	        mav.addObject("message",
	                "成功上传 '" + file.getOriginalFilename() + "'");
	        
	        Runtime.getRuntime().exec("chmod 777 -R " + uploadFilePath);
	        
	        mav.addObject("url", "http://47.98.137.92/"+sort+"/" +myFmt.format(new Date())+file.getOriginalFilename());
	        mav.setViewName("result");
	        return mav;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return mav;
	}
}
