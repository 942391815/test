//package com.test.java.testtimer;
//
//import com.taobao.pamirs.schedule.CronExpression;
//import com.taobao.pamirs.schedule.ScheduleUtil;
//
//import java.util.Date;
//import java.util.Timer;
//
///**
// * Created by qiaogu on 2017/10/18.
// */
//public class Test {
//    public static void main(String[] args) throws Exception {
//        Timer heartBeatTimer = new Timer("-HeartBeat");
//        String startTmsStr = "0 * * * * ?";
//        String endTmsStr = "5 * * * * ?";
//
//        CronExpression cexpStart = new CronExpression(startTmsStr);
//        while (true) {
//            Date current = new Date();
//
//            Date firstStartTime = cexpStart.getNextValidTimeAfter(current);
//
//                heartBeatTimer.schedule(
//                        new PauseOrResumeScheduleTask(heartBeatTimer,
//                                PauseOrResumeScheduleTask.TYPE_RESUME, startTmsStr),
//                        firstStartTime);
//
//
//            CronExpression cexpEnd = new CronExpression(endTmsStr);
//            Date firstEndTime = cexpEnd.getNextValidTimeAfter(current);
//            heartBeatTimer.schedule(
//                    new PauseOrResumeScheduleTask(heartBeatTimer,
//                            PauseOrResumeScheduleTask.TYPE_PAUSE, endTmsStr),
//                    firstEndTime);
//        }
//
//    }
//}
