package com.test.java.exam;

import com.test.java.IndexReaderUtils;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

import java.nio.file.Paths;

/**
 * Created by qiaogu on 2017/1/14.
 */
public class Page {
    public static void main(String[] args) throws Exception{
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexReader indexReader = IndexReaderUtils.getIndexReader(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        indexSearcher.searchAfter(null,null,12);
    }
}
