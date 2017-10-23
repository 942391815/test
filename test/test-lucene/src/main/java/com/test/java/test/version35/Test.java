package com.test.java.test.version35;


import com.test.java.es.EsUtils;
import org.elasticsearch.client.transport.TransportClient;

/**
 * Created by qiaogu on 2017/1/8.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        TransportClient client = EsUtils.localClient();
    }
}
