package com.qinmei.spring2boot.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日下午1:19:41
 */
@Component
public class SchedulerTask {

	private int count=0;
 
	/**
	 * (cron="0 0 1 * * *") //每天凌晨1点执行一次    ,cron表达式，设置定时时间
	 * */
    @Scheduled(cron="*/6 * * * * ?") // 每 6s 执行一次 
    private void process(){
        //System.out.println("this is scheduler task runing  "+(count++));
    }
}
