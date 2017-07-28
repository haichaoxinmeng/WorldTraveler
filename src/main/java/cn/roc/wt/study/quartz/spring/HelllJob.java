package cn.roc.wt.study.quartz.spring;

import cn.roc.wt.common.util.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 11:16 2017/7/26
 * @Modified By:
 */
public class HelllJob implements Job{           //创建一个Job类，此类必须继承QuartzJobBean抽象类或者实现Job接口（QuartzJobBean实现了Job接口）

    private Logger logger = LoggerFactory.getLogger(HelllJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("时间....."+ DateUtil.formatDateTime()+".......Spring集成Quartz...."+jobExecutionContext.getJobDetail().getKey());
    }
}
