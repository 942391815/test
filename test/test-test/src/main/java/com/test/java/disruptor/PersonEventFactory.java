package com.test.java.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by qiaogu on 2017/11/15.
 */
public class PersonEventFactory implements EventFactory<PersonEvent> {
    @Override
    public PersonEvent newInstance() {
        return new PersonEvent();
    }
}
