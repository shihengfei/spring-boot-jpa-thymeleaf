package com.qinmei.spring2boot.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * 
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日下午1:19:41
 */
@Component
public class SchedulerTask2 {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
	 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
	 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
	 */
	@Scheduled(fixedRate = 6000)
	public void reportCurrentTime() {
		//System.out.println("现在时间：" + dateFormat.format(new Date()));
	}
}
