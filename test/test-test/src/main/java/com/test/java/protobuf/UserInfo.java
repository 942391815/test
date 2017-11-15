package com.test.java.protobuf;

import org.msgpack.annotation.Message;

/**
 * Created by qiaogu on 2017/11/9.
 */
@Message
public class UserInfo {


    private String userName;
    private int userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public UserInfo buildUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserID(int userID) {
        this.userID = userID;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfo [userName=" + userName + ", userID=" + userID + "]";
    }
}