package com.test.java.test;

import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qiaogu on 2017/8/7.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
//        ConcurrentHashMap<String,String> curr = new ConcurrentHashMap<>();
//        curr.put("aa","bb");
//        System.out.println(curr.putIfAbsent("aa","cc"));
//        System.out.println(curr.putIfAbsent("dd","cc"));
//        System.out.println(curr.putIfAbsent("dd","cc"));

//        LocalTime jobTime = LocalTime.parse("01:20:14");
//        LocalDateTime of = LocalDateTime.of(LocalDate.now(), jobTime);
//        Date jobStartTime = Date.from(of.atZone(ZoneId.systemDefault()).toInstant());
//        DateTimeFormatter dateTimeFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateTimeFormater.format(of));
//        System.out.println(jobStartTime);
//        System.out.println(dateTimeFormater.format(jobStartTime));
//        int count = pushJobItemDAO.countJobStartTime(pushJob.getId(), dateTimeFormater.format(of));

        StopWatch stopWatch = new StopWatch("定时任务");
        stopWatch.start("起床 ");
        Thread.sleep(1000);
        stopWatch.stop();
        stopWatch.start("刷牙 ");
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskInfo());
    }
}
