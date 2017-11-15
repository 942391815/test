package com.test.java.testtrue;

/**
 * Created by qiaogu on 2017/10/25.
 */
public class Test {
    public static void main(String[] args) {
        int count = 0;
        do {
            try {
                process();
                break;
            } catch (Exception e) {
//                count++;
//                if (count > 5) {
//                    System.out.println("count ..." + count);
//                    break;
//                }
                System.out.println(456);
            }catch (Throwable e){
                System.out.println(123123);
            }
            break;
        } while (true);
    }

    private static void process() {
        throw new RuntimeException("asdfasdf");
    }
}
