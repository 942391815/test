package com.test.java;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

/**
 * Created by qiaogu on 2016/12/11.
 */
public class IndexWriterUtis {
    public static IndexWriter getIndexWriter(Directory directory) throws Exception{
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        return new IndexWriter(directory,config);
    }
}
