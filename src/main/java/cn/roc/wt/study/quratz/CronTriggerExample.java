package cn.roc.wt.study.quratz;

import cn.roc.wt.common.util.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 17:19 2017/7/24
 * @Modified By:
 */
public class CronTriggerExample {

    public void example1() {
        try {

            System.out.println(DateUtil.formatDateTime());
            /**
             * 每20秒运行一次
             */
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1","group1").build();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(("0/20 * * * * ?"))).build();

            scheduler.scheduleJob(jobDetail,cronTrigger);


            /**
             * 每两分钟、15秒执行一次
             */
            jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job2","group2").build();

            cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2","group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("15 0/2 * * * ? *")).build();

            scheduler.scheduleJob(jobDetail,cronTrigger);


            /**
             * 在什么时间段，间隔多少时间执行一次
             */
            jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job3","group3").build();

            cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger3","group3")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 11-12 * * ? *")).build();

            scheduler.scheduleJob(jobDetail,cronTrigger);

            /**
             * 在什么时间执行
             */
            jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job4","group4").build();

            cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger4","group4")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10am 25,27 * ? *")).build();  //表示 在每月的25号、27号 上午10点钟执行任务

            scheduler.scheduleJob(jobDetail,cronTrigger);

            /**
             * 在周几执行
             */
            jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job5","group5").build();

            cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger5","group5")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * ? * MON-FRI *")).build();       //表示 在每月周一至周五 0、30秒的时候，执行任务
                                                                                // "0,30 * * ? * MON,FRI *"  //表示 在每月周一和周五 0、30秒的时候，执行任务

            scheduler.scheduleJob(jobDetail,cronTrigger);

            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CronTriggerExample().example1();
    }
}
