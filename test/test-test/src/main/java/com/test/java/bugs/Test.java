package com.test.java.bugs;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;

/**
 * Created by Micheal on 2020/1/25.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\36");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("D:\\22");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = null;
        String subLine = "";
        List<String> tempList = Lists.newArrayList();
        while ((line = bufferedReader.readLine()) != null) {
            tempList.add(line);
        }
        List<String> result = Lists.newArrayList();
        String join = "";
        for (String each : tempList) {
            if(each.equals("")){
                continue;
            }
            if (isTrime(each)) {
                if (isStart(each)) {
                    join = each;
                } else if (isEnd(each)) {
                    join = join.concat(" ").concat(each);
                    result.add(join);
                    join = "";
                } else {
                    join = join.concat(" ").concat(each);
                }
            } else {
                result.add(each);
            }
        }
        for (String each : result) {
            System.out.println(each);
        }
    }

    public static boolean isTrime(String each) {
        return each.startsWith("A") || each.startsWith("B")
                || each.startsWith("C") || each.startsWith("D") ||each.startsWith("E");
    }

    public static boolean isStart(String each) {
        return each.startsWith("A");
    }

    public static boolean isEnd(String each) {
        return each.startsWith("E");
    }
}
