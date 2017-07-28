package cn.roc.wt.study.quartz;

/**
 * @Author Roc Chen
 * @Description
 * @Date:Created ChenQiang in 17:10 2017/7/24
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        new Main().SimpleTriggerTest();

    }

    public void CronTriggerTest(){
        new CronTriggerExample().example1();
    }
    public void SimpleTriggerTest(){
//        new SimpleTriggerExample().example1();
//        new SimpleTriggerExample().example2();
    }
}
