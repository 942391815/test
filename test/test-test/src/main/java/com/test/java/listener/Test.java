package com.test.java.listener;

import org.apache.commons.lang3.event.EventListenerSupport;
/**
 * Created by Micheal on 2019/1/24.
 */
public class Test {
    public static void main(String[] args) {
        EventListenerSupport<IListener> eventListener = EventListenerSupport.create(IListener.class);
        eventListener.addListener(new TestListener());
        eventListener.fire().onListener();
    }
}
