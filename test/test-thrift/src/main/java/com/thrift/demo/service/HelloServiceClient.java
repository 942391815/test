package com.thrift.demo.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloServiceClient {
    public static void main(String[] args) {
        try {
            TTransport tTransport = getTTransport();
            TProtocol protocol = new TBinaryProtocol(tTransport);
            Hello.Client client = new Hello.Client(protocol);
            String result = client.helloString("hello");
            System.out.println("The result is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TTransport getTTransport() throws Exception {
        try {
            TTransport tTransport = getTTransport("127.0.0.1", 7911, 5000);
            if (!tTransport.isOpen()) {
                tTransport.open();
            }
            return tTransport;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static TTransport getTTransport(String host, int port, int timeout) {
        final TSocket tSocket = new TSocket(host, port, timeout);
        final TTransport transport = new TFramedTransport(tSocket);
        return transport;
    }
}