package com.test.java.redis.pub;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisSubTest {
    @Test
    public void subjava() {
        System.out.println("订阅者 ");
        Jedis jr = null;
        try {
            jr = new Jedis("127.0.0.1", 6379, 0);// redis服务地址和端口号
            RedisMsgPubSubListener sp = new RedisMsgPubSubListener();
            // jr客户端配置监听两个channel
            jr.subscribe(sp, "news.share", "news.blog");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }
}