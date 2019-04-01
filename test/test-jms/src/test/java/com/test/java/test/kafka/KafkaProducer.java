//package com.test.java.test.kafka;
//
//import kafka.javaapi.producer.Producer;
//import kafka.producer.KeyedMessage;
//import kafka.producer.ProducerConfig;
//
//import java.util.Properties;
//import java.util.Random;
//
///**
// * Created by Micheal on 2016/8/21.
// */
//public class KafkaProducer {
//    public static void main(String[] args) {
//        String topic= "test11";
//        long events = 10000;
//        Random rand = new Random();
//
//        Properties props = new Properties();
//        props.put("metadata.broker.list", "127.0.0.1:9092");
//        props.put("serializer.class", "kafka.serializer.StringEncoder");
//        props.put("request.required.acks", "1");
//
//        ProducerConfig config = new ProducerConfig(props);
//
//        Producer<String, String> producer = new Producer<String, String>(config);
//
//        for (long nEvents = 0; nEvents < events; nEvents++) {
////            String msg = "NativeMessage-" + rand.nextInt() ;
//            String msg = "NativeMessage-11111111" + rand.nextInt() ;
//            KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, nEvents + "", msg);
//            System.out.println(msg);
//            producer.send(data);
//        }
//        producer.close();
//
//    }
//}
