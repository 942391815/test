//package com.test.java.test;
//
//import com.test.java.IndexReaderUtils;
//import com.test.java.IndexWriterUtis;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.standard.StandardAnalyzer;
//import org.apache.lucene.document.*;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.queryparser.classic.QueryParser;
//import org.apache.lucene.search.*;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//import org.apache.lucene.store.RAMDirectory;
//
//import java.nio.file.Paths;
//
///**
// * Created by qiaogu on 2016/12/11.
// */
//public class Test {
//    public static void main(String[] args) throws Exception{
//        Analyzer analyzer = new StandardAnalyzer();
//
//        //将索引存储到内存中
//        Directory directory = new RAMDirectory();
//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter iwriter = new IndexWriter(directory, config);
//
//        String[] texts = new String[]{
//                "Mybatis分页插件 - 示例",
//                "Mybatis 贴吧问答 第一期",
//                "Mybatis 示例之 复杂(complex)属性(property)",
//                "Mybatis极其(最)简(好)单(用)的一个分页插件",
//                "Mybatis 的Log4j日志输出问题 - 以及有关日志的所有问题",
//                "Mybatis 示例之 foreach （下）",
//                "Mybatis 示例之 foreach （上）",
//                "Mybatis 示例之 SelectKey",
//                "Mybatis 示例之 Association (2)",
//                "Mybatis 示例之 Association"
//        };
//
//        for (String text : texts) {
//            Document doc = new Document();
//            doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
//
////            new LongField("fieldValue", 150L, Field.Store.YES);
////            doc.add(new LongField("fieldValue", 150L,FieldType.NumericType));
//
////            doc.add(new NumericDocValuesField("fieldValue",300));
//            doc.add(new LongField("fieldValue", 150L, Field.Store.YES));
//            iwriter.addDocument(doc);
//        }
//        iwriter.close();
//
//        //读取索引并查询
//        DirectoryReader ireader = DirectoryReader.open(directory);
//        IndexSearcher isearcher = new IndexSearcher(ireader);
//        //解析一个简单的查询
//        QueryParser parser = new QueryParser("fieldname", analyzer);
//        Query query = parser.parse("foreach");
//        ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
//        //迭代输出结果
//        for (int i = 0; i < hits.length; i++) {
//            Document hitDoc = isearcher.doc(hits[i].doc);
//            System.out.println(hitDoc);
//        }
//
//        long start = 100;
//        long end = 500;
//        Query query1 = NumericRangeQuery.newLongRange("fieldValue", start, end, true,true);
//        TopDocs tds=isearcher.search(query1, 10);
//        for(ScoreDoc sd:tds.scoreDocs)
//        {
//            Document doc=isearcher.doc(sd.doc);
//            System.out.println(doc.toString());
//        }
//
//
//        ireader.close();
//        directory.close();
////        read();
//    }
//
//    public static void read(){
//        try {
//            FSDirectory fsDirectory = FSDirectory.open(Paths.get("E://lucene"));
//            IndexReader indexReader = IndexReaderUtils.getIndexWriter(fsDirectory);
//            IndexSearcher searcher = new IndexSearcher(indexReader);
//            QueryParser country = new QueryParser("contents", new StandardAnalyzer());
//
//            Query query = country.parse("branges");
//            TopDocs search = searcher.search(query, 100);
//
//            for (int i =0;i<search.scoreDocs.length;i++){
//                Document doc = searcher.doc(i);
//                System.out.println(doc.get("contents"));
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public static  void write(){
//        try {
//            String [] ids = {"1","2"};
//            String []unindexed = {"nitherlands"," italy"};
//            String[] unstored={"Amsterdam has a lots of branges","Venice has lots of canals"};
//            String [] text = {"Amsterdam","Venice"};
//
//            FSDirectory fsDirectory = FSDirectory.open(Paths.get("E://lucene"));
//            IndexWriter writer = IndexWriterUtis.getIndexWriter(fsDirectory);
//            for (int i=0;i<ids.length;i++){
//                Document doc = new Document();
//                doc.add(new Field("id",ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
//                doc.add(new Field("country",unindexed[i],Field.Store.YES,Field.Index.NO));
//                doc.add(new Field("contents",unstored[i],Field.Store.NO,Field.Index.ANALYZED));
//                doc.add(new Field("city",text[i],Field.Store.YES,Field.Index.ANALYZED));
//                writer.addDocument(doc);
//            }
//            writer.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}
