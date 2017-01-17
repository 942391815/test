//package com.test.java.test.version35;
//
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.store.FSDirectory;
//import org.apache.lucene.util.Version;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileReader;
//
///**
// * Created by qiaogu on 2017/1/8.
// */
//public class Test {
//    public static void main(String[] args) throws Exception{
//        FSDirectory open = FSDirectory.open(new File("E:\\index"));
//        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35, new StandardAnalyzer(Version.LUCENE_35));
//        IndexWriter writer = new IndexWriter(open, config);
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\u.data"));
//        String s = bufferedReader.readLine();
//        System.out.println(s);
//        String[] split = bufferedReader.readLine().split("\t");
//        System.out.println(split[0]+"---"+split[1]+"---"+split[2]);
//
//        bufferedReader.close();
//    }
//}
