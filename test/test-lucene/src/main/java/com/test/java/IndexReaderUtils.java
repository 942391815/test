package com.test.java;


import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;

/**
 * Created by qiaogu on 2016/12/11.
 */
public class IndexReaderUtils {
    public static IndexReader getIndexReader(Directory directory) throws Exception {
        return DirectoryReader.open(directory);
    }
}
