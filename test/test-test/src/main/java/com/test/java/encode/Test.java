package com.test.java.encode;

//import com.alibaba.druid.support.json.JSONUtils;
//import com.alibaba.dubbo.common.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Micheal on 2019/3/6.
 */
public class Test {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User u1 = new User("manu", 21);
        User u2 = new User("sas", 20);
        User u3 = new User("manu", 20);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        System.out.println("comparable:");
        for (User user : list) {
            System.out.println(user.getName() + ":" + user.getAge());
        }
        //外部排序1
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
//                if (user1.getName().equals(user2.getName())) {
                    return user1.getAge() - user2.getAge();
//                }
//                else {
//                    return user1.getName().compareTo(user2.getName());
//                }
            }
        });
        System.out.println(list);
    }
}
