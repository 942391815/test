package com.test.java.hytrix;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


/**
 * Created by qiaogu on 2019/4/23.
 */
public class Reactor {
    public static void main(String[] args) {
//        Flux.just("Hello", "World").subscribe(System.out::println);
//        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
//        Flux.empty().subscribe(System.out::println);
//        Flux.range(1, 10).subscribe(System.out::println);
//        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
//        Flux.intervalMillis(1000).subscribe(System.out::println);
//        Flux.generate(sink -> {
//            sink.next("Hello");
//            sink.complete();
//        }).subscribe(System.out::println);
//        Flux.create(sink -> {
//            for (int i = 0; i < 10; i++) {
//                sink.next(i);
//            }
//            sink.complete();
//        }).subscribe(System.out::println);
        Flux.range(1, 10)
                .parallel(2).runOn(Schedulers.parallel())
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
//        Flux.range(1, 10)
//                .parallel(2)
//                .runOn(Schedulers.parallel())
//                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));
    }
}
