package com.thrift.demo.service;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * @param args
     */
    public static void main(String[] args) {
        try {
            TNonblockingServerSocket socket = new TNonblockingServerSocket(7911);
            Hello.Processor processor = new Hello.Processor(new HelloServiceImpl());
            TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);
            arg.protocolFactory(new TBinaryProtocol.Factory());
            arg.transportFactory(new TFramedTransport.Factory());
            arg.processorFactory(new TProcessorFactory(processor));
            TServer server = new TNonblockingServer(arg);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}