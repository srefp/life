package com.sr.core.service;

import com.sr.core.quartz.NotifyJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lkj
 * @date 2021/6/5
 */
@Service
public class JobService {

    @Autowired
    private Scheduler scheduler;

    /**
     * 创建任务
     * @param jobName 任务名称
     * @param jobGroup 任务组
     * @param cron cron表达式
     * @param triggerName 触发器名称
     * @param triggerGroup 触发器组
     * @throws SchedulerException 调度异常
     */
    public void create(
            String jobName,
            String jobGroup,
            String cron,
            String triggerName,
            String triggerGroup)
            throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        // 如果存在这个任务，则删除
        if (scheduler.checkExists(jobKey)) {
            scheduler.deleteJob(jobKey);
        }

        JobDetail jobDetail = JobBuilder.newJob(NotifyJob.class)
                .withIdentity(jobKey)
                .build();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(cronScheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
