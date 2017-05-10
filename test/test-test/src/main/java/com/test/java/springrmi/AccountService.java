package com.test.java.springrmi;

/**
 * Created by qiaogu on 2017/5/9.
 */
public interface AccountService {
    int queryBalance(String mobileNo);
    String shoopingPayment(String mobileNo, byte protocol);
}