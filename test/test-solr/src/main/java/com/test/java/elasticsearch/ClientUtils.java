//package com.test.java.elasticsearch;
//
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//
//import java.net.InetAddress;
//
///**
// * Created by Micheal on 2016/9/16.
// */
//public class ClientUtils {
//    public static Client getClient(){
////        Settings settings = ImmutableSettings.settingsBuilder()
////                .put("cluster.name", "elasticsearch")
////                .build();
////        Client client = new TransportClient(settings)
////                .addTransportAddress(new InetSocketTransportAddress(
////                        "localhost", 9300));
//        TransportClient client = null;
//        try {
//            client = TransportClient.builder().build()
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return client;
//    }
//
//    public static void main(String[] args) {
//        getClient();
//        System.out.println(1123123);
//    }
//}
