package com.test.java.map;

import org.springframework.core.CollectionFactory;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.util.AutoPopulatingList;
import org.springframework.util.IdGenerator;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.SimpleIdGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by Micheal on 2019/1/28.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(LocalTime.now());
//        System.out.println(LocalTime.of(23,59,59));
//        System.out.println(LocalTime.parse("23:59:59"));
//
//        LocalDateTime.parse("");
        ConcurrentHashMap<String,String> test = new ConcurrentHashMap<>();
        test.put("123","123");
        System.out.println(test.put("123","1231"));
//        System.out.println(test.get("sun.misc.VMSupport"));
    }
}
