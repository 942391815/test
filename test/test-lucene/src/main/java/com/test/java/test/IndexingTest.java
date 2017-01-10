package com.test.java.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.IOException;
import java.util.List;

/**
 * Created by qiaogu on 2016/12/11.
 */
public class IndexingTest {
    public static void main(String[] args) throws Exception {
        testMultiFieldQueryParser();
    }

    public static void testMultiFieldQueryParser() throws Exception {
        RAMDirectory directory = getRamDirectory();
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);


        String[] queries = {"name1", "content10"};//关键字
        String[] fields = {"name", "content"};//所在对应Fields
        BooleanClause.Occur[] clauses = {BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};

        Query parse1 = MultiFieldQueryParser.parse(queries, fields, clauses, new StandardAnalyzer());

        System.out.println(parse1.toString());

        TopDocs search = indexSearcher.search(parse1, 100);
        ScoreDoc[] scoreDocs = search.scoreDocs;
        System.out.println(search.totalHits);

        for (int i = 0; i < scoreDocs.length; i++) {
            Document hitDoc = indexSearcher.doc(scoreDocs[i].doc);
            List<IndexableField> fields1 = hitDoc.getFields();
            System.out.println(hitDoc.get("name"));
            System.out.println(hitDoc.get("content"));
            for (IndexableField each:fields1){
                System.out.println(each);
            }
            System.out.println(JSONObject.toJSONString(fields1));
        }
    }

    public static void testBooleanQuery() throws Exception {
        RAMDirectory directory = getRamDirectory();
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        NumericRangeQuery<Integer> ageQuery = NumericRangeQuery.newIntRange("age", 1, 20, true, true);
        TermQuery termQuery = new TermQuery(new Term("name", "name20"));

        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        builder.add(ageQuery, BooleanClause.Occur.MUST);
        builder.add(termQuery, BooleanClause.Occur.MUST_NOT);

        TopDocs search = indexSearcher.search(builder.build(), 100);
        System.out.println(search.totalHits);

    }

    public static void testProfixQuery() throws Exception {

        RAMDirectory directory = getRamDirectory();
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        PrefixQuery prefixQuery = new PrefixQuery(new Term("name", "name1"));
        TopDocs search = indexSearcher.search(prefixQuery, 100);
        System.out.println(search.totalHits);

        TopDocs search1 = indexSearcher.search(new TermQuery(new Term("name", "name1")), 100);
        System.out.println(search1.totalHits);
    }

    public static void testTermQuery() throws Exception {
        RAMDirectory directory = getRamDirectory();

        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        TermRangeQuery termRangeQuery = new TermRangeQuery("name", new BytesRef("name1".getBytes()), new BytesRef("name7".getBytes()), true, true);

        TopDocs search = indexSearcher.search(termRangeQuery, 100);
        for (int i = 0; i < search.totalHits; i++) {
            Document doc = indexSearcher.doc(i);
            System.out.println(doc.get("name"));
        }
    }

    private static RAMDirectory getRamDirectory() throws IOException {
        RAMDirectory directory = new RAMDirectory();
        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(standardAnalyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);

        for (int i = 0; i < 100; i++) {
            Document document = new Document();
            document.add(new IntField("age", i, Field.Store.YES));
            document.add(new StringField("name", "name" + i, Field.Store.YES));
            document.add(new StringField("content", "content" + i, Field.Store.YES));
            indexWriter.addDocument(document);
        }
        indexWriter.close();
        return directory;
    }

    public static void testNumberRangeQuery() throws Exception {
        RAMDirectory directory = getRamDirectory();

        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);

        NumericRangeQuery<Integer> rangeQuery = NumericRangeQuery.newIntRange("age", 1, 10, true, true);

        TopDocs topDocs = indexSearcher.search(rangeQuery, 5);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (int i = 0; i < scoreDocs.length; i++) {
            Document hitDoc = indexSearcher.doc(scoreDocs[i].doc);
            System.out.println(hitDoc.get("age"));
            System.out.println(JSONObject.toJSONString(hitDoc));
        }
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        builder.add(rangeQuery, BooleanClause.Occur.MUST);

        TermQuery termQuery = new TermQuery(new Term("name", "name7"));
        builder.add(termQuery, BooleanClause.Occur.MUST_NOT);

        TopDocs search = indexSearcher.search(builder.build(), 5);
        System.out.println("total hits ..." + search.totalHits);
    }

    class Person {
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
