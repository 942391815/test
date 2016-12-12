//package com.test.java.test;
//
//import org.apache.lucene.analysis.WhitespaceAnalyzer;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.Term;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.TermQuery;
//import org.apache.lucene.search.TopDocs;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.RAMDirectory;
//
///**
// * Created by qiaogu on 2016/12/11.
// */
//public class IndexingTest {
//    protected String [] ids = {"1","2"};
//    private  String []unindexed = {"nitherlands"," italy"};
//    private String[] unstored={"Amsterdam has a lots of branges","Venice has lots of canals"};
//    private String [] text = {"Amsterdam","Venice"};
//    private Directory directory;
//    protected void setUp() throws Exception{
//        directory = new RAMDirectory();
//
//        IndexWriter writer = getWriter();
//
//        for (int i=0;i<ids.length;i++){
//            Document doc = new Document();
//            doc.add(new Field("id",ids[i],Field.Store.YES,Field.Index.NOT_ANALYZED));
//            doc.add(new Field("country",unindexed[i],Field.Store.YES,Field.Index.NO));
//            doc.add(new Field("contents",unstored[i],Field.Store.NO,Field.Index.ANALYZED));
//            doc.add(new Field("city",text[i],Field.Store.YES,Field.Index.ANALYZED));
//            writer.addDocument(doc);
//        }
//        writer.close();
//    }
//
//    public IndexWriter getWriter() throws Exception{
//        return new IndexWriter(directory,new WhitespaceAnalyzer(),IndexWriter.MaxFieldLength.UNLIMITED);
//    }
//
//
//    private int getHitCount(String fieldName,String searchString) throws Exception{
//        IndexSearcher searcher = new IndexSearcher(directory);
//        Term t = new Term(fieldName,searchString);
//        Query query = new TermQuery(t);
////        searcher.
//        TopDocs search = searcher.search(query, Integer.MAX_VALUE);
////        int hitCount =
//
//        searcher.close();
//        return 0;
//    }
//    public void  testIndexWriter() throws Exception{
//        IndexWriter writer = getWriter();
//        writer.close();
//    }
//    public void testIndexReader() throws Exception{
//        IndexReader reader = IndexReader.open(directory);
//
//    }
//
//}
