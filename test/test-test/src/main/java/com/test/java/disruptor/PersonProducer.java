//package com.test.java.disruptor;
//
//
//import com.lmax.disruptor.RingBuffer;
//import org.apache.commons.lang.math.RandomUtils;
//
///**
// * Created by qiaogu on 2017/11/15.
// */
//public class PersonProducer {
//    private final RingBuffer<PersonEvent> ringBuffer;
//
//    public PersonProducer(RingBuffer<PersonEvent> ringBuffer) {
//        this.ringBuffer = ringBuffer;
//    }
//
//    public void onData() {
//        long sequence = ringBuffer.next();  // Grab the next sequence 获取下一个sequence
//        try {
//            PersonEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor 获取entry对象
//            // for the sequence 对应sequence位置上的event
//            String name = RandomUtils.nextFloat()+"";
//            System.out.println("生产消息...."+name);
//            event.setPerson(new Person(name));  // Fill with data 填充业务数据
//        } finally {
//            ringBuffer.publish(sequence);
//        }
//    }
//}