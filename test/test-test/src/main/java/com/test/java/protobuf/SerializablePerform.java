package com.test.java.protobuf;

import org.msgpack.MessagePack;

/**
 * Created by qiaogu on 2017/11/9.
 */
public class SerializablePerform {


    public static void main(String[] args) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserID(250).buildUserName("saolangjian");
        MessagePack messagePack = new MessagePack();
        //序列化
        byte[] bs = messagePack.write(userInfo);
        System.out.println("byte array's length is : " + bs.length);
        //反序列化
        UserInfo serializableUserinfo = messagePack.read(bs, UserInfo.class);
        System.out.println(serializableUserinfo);
    }
}
