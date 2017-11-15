package com.test.java.testtimer;

import com.taobao.pamirs.schedule.CronExpression;
import com.taobao.pamirs.schedule.ScheduleUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
import java.util.Timer;

/**
 * Created by qiaogu on 2017/10/18.
 */
public class PauseOrResumeScheduleTask extends java.util.TimerTask {
    public static int TYPE_PAUSE = 1;
    public static int TYPE_RESUME = 2;
    Timer timer;
    int type;
    String cronTabExpress;

    public PauseOrResumeScheduleTask(Timer aTimer, int aType, String aCronTabExpress) {
        this.timer = aTimer;
        this.type = aType;
        this.cronTabExpress = aCronTabExpress;
    }

    public void run() {
        try {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            this.cancel();//取消调度任务
            Date current = new Date();
            CronExpression cexp = new CronExpression(this.cronTabExpress);
            Date nextTime = cexp.getNextValidTimeAfter(current);
//            System.out.println(DateFormatUtils.format(nextTime,"yyyy-MM-dd HH:mm:ss"));
            if (this.type == TYPE_PAUSE) {
                System.out.println("paupse_time"+DateFormatUtils.format(current,"yyyy-MM-dd HH:mm:ss"));
                pause("到达终止时间,pause调度");
//                this.manager.getScheduleServer().setNextRunEndTime(ScheduleUtil.transferDataToString(nextTime));
            } else {
                System.out.println("start_time"+DateFormatUtils.format(current,"yyyy-MM-dd HH:mm:ss"));
                resume("到达开始时间,resume调度");
//                this.manager.getScheduleServer().setNextRunStartTime(ScheduleUtil.transferDataToString(nextTime));
            }
            this.timer.schedule(new PauseOrResumeScheduleTask(this.timer, this.type, this.cronTabExpress), nextTime);
        } catch (Exception ex) {
        }
    }

    private void pause(String message) {
        System.out.println("停止");
    }

    private void resume(String message) {
        System.out.println("start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
