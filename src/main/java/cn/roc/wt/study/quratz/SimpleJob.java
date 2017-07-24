package cn.roc.wt.study.quratz;

import cn.roc.wt.common.util.DateUtil;
import org.quartz.*;

/**
 * @Author Roc Chen
 * @Description 简单的任务调用
 * @Date:Created ChenQiang in 10:01 2017/7/24
 * @Modified By:
 */
public class SimpleJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();

        //打印任务详情
        System.out.println( DateUtil.formatDateTime()+" key="+ jobKey);
    }
}
