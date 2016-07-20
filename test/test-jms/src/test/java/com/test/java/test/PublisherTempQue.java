package com.test.java.test;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.tcp.ExceededMaximumConnectionsException;

import javax.jms.*;

/**
 * Created by Micheal on 2016/7/20.
 * 该测试类为创建临时目标
 */
public class PublisherTempQue {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TemporaryQueue temporaryQueue = session.createTemporaryQueue();
        MessageProducer producer = session.createProducer(temporaryQueue);
        System.out.println(123);
        connection.close();
    }
    public static void sendMessage(Session session,MessageProducer producer)throws Exception{
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("test publisher Tempque");
        producer.send(textMessage);
    }
}
