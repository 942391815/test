//package com.test.java.object;
//
//import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
//import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
//import io.netty.handler.codec.marshalling.MarshallerProvider;
//import io.netty.handler.codec.marshalling.MarshallingDecoder;
//import io.netty.handler.codec.marshalling.MarshallingEncoder;
//import io.netty.handler.codec.marshalling.UnmarshallerProvider;
//
//import org.jboss.marshalling.MarshallerFactory;
//import org.jboss.marshalling.Marshalling;
//import org.jboss.marshalling.MarshallingConfiguration;
//
//public class MarshallingCodeCFactory {
//    public static MarshallingDecoder buildMarshallingDecoder() {
//        /*
//         * ͨ�� Marshalling ������� getProvidedMarshallerFactory
//         * ��̬������ȡMarshallerFactory ʵ��, , ���� serial ��ʾ�������� Java ���л���������.������
//         * jboss-marshalling-serial ���ṩ
//         */
//        final MarshallerFactory marshallerFactory = Marshalling
//                .getProvidedMarshallerFactory("serial");
//        /*
//         * ����
//         */
//        final MarshallingConfiguration configuration = new MarshallingConfiguration();
//        configuration.setVersion(5);
//
//        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(
//                marshallerFactory, configuration);
//        /*
//         * provider : �ṩ�� maxSize : �����������ߴ�
//         */
//        int maxSize = 1024 << 2;
//        MarshallingDecoder decoder = new MarshallingDecoder(provider, maxSize);
//        return decoder;
//    }
//
//    public static MarshallingEncoder buildMarshallingEncoder() {
//        final MarshallerFactory marshallerFactory = Marshalling
//                .getProvidedMarshallerFactory("serial");
//        final MarshallingConfiguration configuration = new MarshallingConfiguration();
//        configuration.setVersion(5);
//        MarshallerProvider provider = new DefaultMarshallerProvider(
//                marshallerFactory, configuration);
//        MarshallingEncoder decoder = new MarshallingEncoder(provider);
//        return decoder;
//    }
//
//}
// 