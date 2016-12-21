package com.test.java.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;

/**
 * Created by qiaogu on 2016/12/11.
 */
public class IndexingTest {
    public static void main(String[] args) throws Exception{
        RAMDirectory directory = new RAMDirectory();
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(standardAnalyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        for(int i=0;i<100;i++){
            Document document = new Document();
            document.add(new IntField("age",i, Field.Store.YES));
            document.add(new StringField("name","name"+i, Field.Store.YES));
            indexWriter.addDocument(document);
        }
        indexWriter.close();

        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);

//        Query ageTerm = new TermQuery(new Term("age", "7"));
//        Query ageTerm = new TermQuery(new Term("age", "7"));

//        new NumericRangeQuery<Integer>
        NumericRangeQuery<Integer> rangeQuery = NumericRangeQuery.newIntRange("age",1, 10, true, true);

        TopDocs topDocs = indexSearcher.search(rangeQuery, 5);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(int i=0;i<scoreDocs.length;i++){
            Document hitDoc = indexSearcher.doc(scoreDocs[i].doc);
            System.out.println(hitDoc.get("name"));
            System.out.println(JSONObject.toJSONString(hitDoc));
        }

    }

    class Person{
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
