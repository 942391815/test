package com.test.java.elasticsearch;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * Created by Micheal on 2016/9/16.
 */
public class ClientUtils {
    public static Client getClient(){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", "elasticsearch")
                .build();
        Client client = new TransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(
                        "127.0.0.1", 9300));
        return client;
    }
}
