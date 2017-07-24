package cn.roc.wt.study.quratz;

import cn.roc.wt.common.util.DateUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Date;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 10:31 2017/7/24
 * @Modified By:
 */
public class SimpleTriggerExample {
    /**
     * 用例1：简单的任务调度
     */
    public void example1() {
        System.out.println("example1 开始");
        try {
            //调度器
            SchedulerFactory sf = new StdSchedulerFactory();        //任务调度器：工厂
            Scheduler sched = sf.getScheduler();                    //使用工厂，获取一个调度器

            Date runTime = DateBuilder.evenMinuteDate(new Date());  //获取时间

            //任务
            JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("job1", "group1").build();

            //触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

            //任务、触发器注入调度器
            sched.scheduleJob(job, trigger);

            //调用
            sched.start();

            //暂停65秒
            Thread.sleep(65L * 1000L);

            //关闭调度器
            sched.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用例2：SimpleTrigger 触发器，当且仅需触发一次或者以固定时间间隔周期触发执行；
     */
    public void example2() {
        try {
            //调度器
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            Date startTime = DateBuilder.nextGivenSecondDate(null, 15);     //构建一个15秒之后的时间
            System.out.println("startTime="+ DateUtil.format(new Date(),DateUtil.DATETIME_FORMAT));
            System.out.println("startTime="+ DateUtil.format(startTime,DateUtil.DATETIME_FORMAT));

            //TODO:SimpleTrigger

            //只执行一次的任务
            JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("job1", "group1").build();

            SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(startTime).build();

            Date ft = scheduler.scheduleJob(job, trigger);

            System.out.println(job.getKey() + " will run at: " + DateUtil.format(ft,DateUtil.DATETIME_FORMAT) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                    + trigger.getRepeatInterval() / 1000 + " seconds");


            /**
             * 间隔多少时间执行任务，执行多少次
             * withIntervalInSeconds():间隔多久执行一次：单位：秒
             * withRepeatCount():执行多少次
             */
            job = JobBuilder.newJob(SimpleJob.class).withIdentity("job2", "group1").build();

            trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).build();

            ft = scheduler.scheduleJob(job,trigger);

            System.out.println(job.getKey() + " will run at: " + DateUtil.format(ft,DateUtil.DATETIME_FORMAT) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                    + trigger.getRepeatInterval() / 1000 + " seconds");

            /**
             * 多少分钟后，执行任务，仅执行一次
             * futureDate():多少时间后，执行任务
             * DateBuilder.futureDate(2, DateBuilder.IntervalUnit.MINUTE)：得到一个多少分钟后的时间作为任务的开始时间
             */
            job = JobBuilder.newJob(SimpleJob.class).withIdentity("job3","group1").build();

            trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("trigger3","group1")
                    .startAt(DateBuilder.futureDate(2, DateBuilder.IntervalUnit.MINUTE)).build();

            ft = scheduler.scheduleJob(job,trigger);

            System.out.println(job.getKey() + " will run at: " + DateUtil.format(ft,DateUtil.DATETIME_FORMAT) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                    + trigger.getRepeatInterval() / 1000 + " seconds");


            /**
             * 间隔多少时间，执行任务，执行无数次
             * withIntervalInSeconds():间隔多久执行一次：单位：秒
             * SimpleScheduleBuilder.simpleSchedule():还有间隔多少分钟、多少小时的方法
             */
            job = JobBuilder.newJob(SimpleJob.class).withIdentity("job4", "group1").build();

            trigger = TriggerBuilder.newTrigger().withIdentity("trigger4", "group1")
                    .startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(60)
                            .repeatForever())
                    .build();

//            ft = scheduler.scheduleJob(job,trigger);

            System.out.println(job.getKey() + " will run at: " + DateUtil.format(ft,DateUtil.DATETIME_FORMAT) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                    + trigger.getRepeatInterval() / 1000 + " seconds");


            /**
             * 间隔多少时间，执行任务，到什么时间结束任务
             * withIntervalInMinutes():间隔多少时间：单位分钟
             * endAt():结束时间
             */
            job = JobBuilder.newJob(SimpleJob.class).withIdentity("job5","group1").build();

            trigger = TriggerBuilder.newTrigger().withIdentity("trigger5", "group1")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInMinutes(1)
                            .repeatForever())
                    .endAt(DateBuilder.dateOf(16, 30, 0))
                    .build();

            scheduler.scheduleJob(job,trigger);

            scheduler.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
