package com.test.java.util;

import com.alibaba.fastjson.JSONObject;
import com.test.java.util.string.StringUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Micheal on 2020/11/7.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\1.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (bufferedReader.read() != -1) {
            String eachLine = bufferedReader.readLine();
            String[] split = eachLine.split("\t");
            for (int i = 0; i < split.length; i++) {
                if (i == 0 || i == 1) {
                    continue;
                }
                String afterTrim = split[i].replace(" ","");
                if (StringUtils.isNotBlank(afterTrim)) {
                    if (!map.containsKey(afterTrim)) {
                        map.put(afterTrim, 1);
                    } else {
                        map.put(afterTrim, map.get(afterTrim) + 1);
                    }
                }
            }
        }
        Map<String, Integer> result = sortDescend(map);
        System.out.println(JSONObject.toJSONString(result));


    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }

}
