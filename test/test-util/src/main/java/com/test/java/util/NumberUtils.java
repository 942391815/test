package com.test.java.util;

import java.util.regex.Pattern;

/**
 * Created by qiaogu on 2017/1/10.
 */
public class NumberUtils {
    public static boolean isNumber(String number) {
        String regxNumber = "^[0-9]*$";
        String regxENumber = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";

        Pattern patternNumber = Pattern.compile(regxNumber);
        Pattern patternENumber = Pattern.compile(regxENumber);
        return patternNumber.matcher(number).matches()||patternENumber.matcher(number).matches();
    }

    public static void main(String[] args) {
        System.out.println(isNumber("1.601010302E9"));
    }
}


