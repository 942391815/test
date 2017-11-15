package com.test.java.disruptor;

import com.alibaba.druid.support.json.JSONUtils;
import com.lmax.disruptor.EventHandler;

/**
 * Created by qiaogu on 2017/11/15.
 */
public class PersonEventHandler implements EventHandler<PersonEvent> {
    private String name;

    public PersonEventHandler(String name) {
        this.name = name;
    }

    public PersonEventHandler() {
    }

    @Override
    public void onEvent(PersonEvent event, long sequence, boolean endOfBatch) throws Exception {
        Person person = event.getPerson();
        System.out.println("消费消息。。。" + person.getName());
    }
}
