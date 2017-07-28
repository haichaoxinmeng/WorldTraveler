package cn.roc.wt.study.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 17:19 2017/7/24
 * @Modified By:
 */
public class ColorJob {
    private Logger logger = LoggerFactory.getLogger(ColorJob.class);

    public static void main(String[] args) {
        new ColorJob().logger.info("日志打印");
    }
}
