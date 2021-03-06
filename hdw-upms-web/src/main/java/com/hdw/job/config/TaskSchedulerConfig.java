package com.hdw.job.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @Description Spring Task定时任务配置
 * @Author TuMinglong
 * @Date 2019/1/18 16:14
 **/
@Configuration
public class TaskSchedulerConfig {

    @Value("${hdw.scheduler.name}")
    private String schedulerName;

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        //线程池大小
        scheduler.setPoolSize(10);
        //线程名字前缀
        scheduler.setThreadNamePrefix(schedulerName + "-task-thread-");
        return scheduler;
    }
}
