package com.test.java.keycenter;

import com.xiaomi.keycenter.agent.client.DataProtectionProvider;

/**
 * Created by Micheal on 2020/12/10.
 */
public class HelloWorld {
    public static void main(String[] args) throws Exception {
        //获得对应sid的数据加解密data protection provider
        DataProtectionProvider provider = DataProtectionProvider.getProvider("keycenter-sid-sample");
        String plain = "abcdefg";

        //加密操作
        byte[] cipher = provider.encrypt(plain.getBytes());
        //解密操作
        String raw = new String(provider.decrypt(cipher));

        if (plain.equals(raw)) {
            System.out.println("ok");
        } else {
            System.out.println("error");
        }
    }
}
