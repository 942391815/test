//package com.test.java.hytrix;
//
//import org.apache.commons.lang.math.RandomUtils;
//import rx.Observable;
//import rx.internal.util.InternalObservableUtils;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by Micheal on 2019/4/18.
// */
//public class Test {
//    @org.junit.Test
//    public void timeWindowTest() throws Exception{
//        Observable<Integer> source = Observable.interval(50, TimeUnit.MILLISECONDS).map(i -> RandomUtils.nextInt(2));
//        source.window(1, TimeUnit.SECONDS).subscribe(window -> {
//            int[] metrics = new int[2];
//            window.subscribe(i -> metrics[i]++,
//                    InternalObservableUtils.ERROR_NOT_IMPLEMENTED,
//
//                    () -> System.out.println("窗口Metrics:" + metrics));
//        });
//        TimeUnit.SECONDS.sleep(3);
//    }
//}
