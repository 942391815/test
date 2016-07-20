package com.test.java.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
    private static final int SEND_NUMBER = 5000;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer producer;
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("FirstQueue");
            producer = session.createProducer(destination);
            /*
            * 消息的传送模式分为两种一种是持久化 DeliveryMode.PERSISTENT默认方式
            * 一种为非持久化 DeliveryMode.NON_PERSISTENT 即如果MQ 重启该消息会丢失
            * */
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            /*
            producer.setPriority();  设置消息的优先级别 优先级高的消息会被先消费
            */
            /*
            producer.setTimeToLive(); 消息的过期时间
            * */

            sendMessage(session, producer);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

    public static void sendMessage(Session session, MessageProducer producer)
            throws Exception {
        for (int i = 1; i <= SEND_NUMBER; i++) {
            TextMessage message = session
                    .createTextMessage("active message ...." + i);
            System.out.println("成功发送消息。。。" + i);
            /*
            * 在大多数情况下发送消息是异步的
            * 在没有使用事务的情况下，生产者以PERSISTENT方式发送消息
            * 这种情况下send方法是同步的，会阻塞到MQ发送确认消息，这种机制保证
            * 消息安全，会消耗吞吐量
            * */
            producer.send(message);
        }
    }
}