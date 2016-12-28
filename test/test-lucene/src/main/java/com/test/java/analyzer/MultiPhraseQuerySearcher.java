package com.test.java.analyzer;

/**
 * Created by qiaogu on 2016/12/27.
 */
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.RAMDirectory;

public class MultiPhraseQuerySearcher {
    public static RAMDirectory dictionary = new RAMDirectory();
    public static void createIndex() throws Exception{    // 建立索引

        IndexWriter writer;
        try {
            IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
            writer = new IndexWriter(dictionary,config);

            Field fieldB1 = new TextField("contents","今晚的辩题很道地：在我们这些人当中？",Field.Store.YES);
            Field fieldB2 = new TextField("contents","我们为电影《今朝》是一部不错的影片。",Field.Store.YES);
            Field fieldB3 = new TextField("contents","我们到底是啥意思呢？",Field.Store.YES);
            Document doc1 = new Document();
            Document doc2 = new Document();
            Document doc3 = new Document();
            doc1.add(fieldB1);
            doc2.add(fieldB2);
            doc3.add(fieldB3);

            writer.addDocument(doc1);
            writer.addDocument(doc2);
            writer.addDocument(doc3);
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Query query;
        IndexSearcher searcher;
        try {
            //生成索引
            createIndex();
            DirectoryReader reader = DirectoryReader.open(dictionary);
            IndexSearcher indexSearcher = new IndexSearcher(reader);
            //要查找的字符串数组
            String [] stringQuery={"我们","今晚"};
            //待查找字符串对应的字段
            String[] fields={"contents","contents"};
            //Occur.MUST表示对应字段必须有查询值， Occur.MUST_NOT 表示对应字段必须没有查询值
            Occur[] occ={Occur.MUST,Occur.MUST};

            query= MultiFieldQueryParser.parse(stringQuery,fields,occ,new SimpleAnalyzer());
            System.out.println(query.toString());
            TopDocs search = indexSearcher.search(query, 100);
            System.out.println(search.totalHits);
        }
        catch (Exception e) {}
    }
}