package cn.roc.wt.study.quartz.spring;

import cn.roc.wt.common.util.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 9:30 2017/7/27
 * @Modified By:
 */
public class MyJob implements Job{
    private Logger logger = LoggerFactory.getLogger(MyJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("时间....."+ DateUtil.formatDateTime()+".......Spring集成Quartz...."+jobExecutionContext.getJobDetail().getKey());
    }
    /**
     * 用例1
     */
    public void example1(){
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();

            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ? *")).build(); //20秒执行一次任务

            scheduler.scheduleJob(jobDetail,trigger);

            jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job2","group2").build();

            trigger = TriggerBuilder.newTrigger().withIdentity("trigger2","group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ? *")).build(); //20秒执行一次任务

            scheduler.scheduleJob(jobDetail,trigger);

            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyJob().example1();
    }
}
