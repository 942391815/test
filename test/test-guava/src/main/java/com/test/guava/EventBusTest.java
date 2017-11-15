package com.test.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.event.ChangeEvent;

/**
 * Created by qiaogu on 2017/10/23.
 */
public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new SubScribe());
        eventBus.post(1);
        eventBus.post(1L);
    }
}

class SubScribe {
    @Subscribe
    public void lister(Integer integer) {
        System.out.printf("%s from int%n", integer);
    }
//    @Subscribe
//    public void testObject(Object ob) {
//        System.out.print(ob);
//    }
}