package com.test.java.nio;


import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * Created by Micheal on 2020/9/23.
 */
public class TestDirectBuffer {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        File file = new File("D:\\code\\CpsBizItem.java");
//        FileChannel fileChannel = FileChannel.open(new Path() {
//        });
    }
}
