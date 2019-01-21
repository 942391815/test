//package com.test.java.disruptor;
//
//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;
//
//import java.nio.ByteBuffer;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Created by qiaogu on 2017/11/15.
// */
//public class Test {
//    public static void main(String[] args) {
//        //生产event的工厂，在disruptor启动的时候用来在ring buffer环中占坑
//        PersonEventFactory factory = new PersonEventFactory();
//
//        //指定ring buffer环的大小
//        int bufferSize = 8;
//
//        //创建disruptor
//        Disruptor<PersonEvent> disruptor = new Disruptor<PersonEvent>(factory, bufferSize,
//                Executors.defaultThreadFactory());
//
//        //注册事件处理器，用来消费事件
//        disruptor.handleEventsWith(new PersonEventHandler("Basic"));
//
//        //启动disruptor
//        disruptor.start();
//
//        //构建生产者，用来生产事件
//        RingBuffer<PersonEvent> ringBuffer = disruptor.getRingBuffer();
//        final PersonProducer producer = new PersonProducer(ringBuffer);
//
//        ExecutorService es = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            es.submit(new Runnable() {
//                public void run() {
//                    ByteBuffer bb = ByteBuffer.allocate(8);
//                    producer.onData();
//                }
//            });
//        }
//        System.out.println("end.....");
//    }
//}
