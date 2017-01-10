package com.test.java.exam;

import com.test.java.IndexReaderUtils;
import com.test.java.IndexWriterUtis;
import com.test.java.util.poi.TestPoi;
import org.apache.lucene.analysis.hunspell.Dictionary;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by qiaogu on 2017/1/10.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexReader indexReader = IndexReaderUtils.getIndexWriter(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        TermQuery termQuery = new TermQuery(new Term("name", "原  超"));
        TopDocs search = indexSearcher.search(termQuery, 100);
        int totalHits = search.totalHits;
        for (int i=0;i<totalHits;i++){
            Document doc = indexSearcher.doc(i);
            System.out.println(doc.get("half_written_score"));
        }
        System.out.println(search.totalHits);
    }


    private static void writeIndex() throws Exception {
        List<Map<String, String>> mapList = TestPoi.analysisExcel(new FileInputStream("D:\\20160807172927448.xls"));
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexWriter indexWriter = IndexWriterUtis.getIndexWriter(directory);
        for (Map<String,String> each:mapList){
            Document document = new Document();
            document.add(new StringField("code",each.get("code"), Field.Store.YES));
            document.add(new StringField("name",each.get("name"), Field.Store.YES));
            document.add(new StringField("job_name",each.get("job_name"), Field.Store.YES));
            document.add(new StringField("job_code",each.get("job_code"), Field.Store.YES));
            document.add(new FloatField("written_score",Float.parseFloat(each.get("written_score")), Field.Store.YES));
            document.add(new FloatField("half_written_score",Float.parseFloat(each.get("half_written_score")), Field.Store.YES));
            document.add(new FloatField("Interview_score",Float.parseFloat(each.get("Interview_score")), Field.Store.YES));
            document.add(new FloatField("all_score",Float.parseFloat(each.get("all_score")), Field.Store.YES));

            document.add(new IntField("rank",Integer.parseInt(each.get("rank")), Field.Store.YES));
            if(each.get("remark")!=null){
                document.add(new StringField("remark",each.get("remark"), Field.Store.YES));
            }
            indexWriter.addDocument(document);
        }
        indexWriter.close();
    }
}
