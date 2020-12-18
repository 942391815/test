package com.test.java.file;

import com.alibaba.druid.support.json.JSONUtils;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by qiaogu on 2020/12/13.
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        FileChannel rw = new RandomAccessFile("d:\\test.txt", "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = rw.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024);
        ByteBuffer slice = mappedByteBuffer.slice();
        slice.put(new String("zhangsan").getBytes());

        System.out.println(mappedByteBuffer.limit()+"---"+mappedByteBuffer.position()+"--"+mappedByteBuffer.capacity());
        System.out.println(slice.limit()+"---"+slice.position()+"---"+slice.capacity());

        mappedByteBuffer.put("new".getBytes());

        System.out.println(mappedByteBuffer.limit()+"---"+mappedByteBuffer.position()+"---"+mappedByteBuffer.capacity());
        System.out.println(slice.limit()+"---"+slice.position()+"---"+slice.capacity());

        System.out.println(mappedByteBuffer.capacity());

    }
}
