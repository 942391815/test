package com.test.java.es.mryt;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by qiaogu on 2016/8/29.
 */
public class MrytEsUtils {
    public static TransportClient localClient() {
        //测试平台
        TransportClient transportClient = null;
        try {
            transportClient = new TransportClient().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return transportClient;
    }
}
