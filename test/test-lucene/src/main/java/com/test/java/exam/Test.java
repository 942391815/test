package com.test.java.exam;

import com.test.java.IndexReaderUtils;
import com.test.java.IndexWriterUtis;
import com.test.java.util.poi.TestPoi;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Created by qiaogu on 2017/1/10.
 */
public class Test {
    public static void main(String[] args) throws Exception{
//        updateIndex();
//        queryIndex();
        writeIndex();
    }

    private static void queryIndex() throws Exception {
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexReader indexReader = IndexReaderUtils.getIndexWriter(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        TermQuery termQuery = new TermQuery(new Term("code", "1601010127"));
        ScoreDoc[] scoreDocs = indexSearcher.search(termQuery, 100).scoreDocs;
        int totalHits = scoreDocs.length;
        for (int i=0;i<totalHits;i++){
            Document doc = indexSearcher.doc(scoreDocs[i].doc);
            System.out.println(doc.get("name"));
        }
    }

    private static void updateIndex() throws Exception {
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexWriter indexWriter = IndexWriterUtis.getIndexWriter(directory);
        Document document = new Document();
        StringField field = new StringField("name", "张聪", Field.Store.YES);
        document.add(field);
        indexWriter.updateDocument(new Term("code","1601010127"),document);
        indexWriter.flush();
        indexWriter.close();
    }


    private static void writeIndex() throws Exception {
        List<Map<String, String>> mapList = TestPoi.analysisExcel(new FileInputStream("D:\\20160807172927448.xls"));
        FSDirectory directory = FSDirectory.open(Paths.get("d:\\index"));
        IndexWriter indexWriter = IndexWriterUtis.getIndexWriter(directory);
        for (int i=0;i<mapList.size();i++){
            Document document = new Document();
            Map<String, String> each = mapList.get(i);

            document.add(new StringField("code",each.get("code"), Field.Store.YES));
            document.add(new StoredField("name",new BytesRef(each.get("name").getBytes())));
            document.add(new StringField("job_name",each.get("job_name"), Field.Store.YES));
            document.add(new StringField("job_code",each.get("job_code"), Field.Store.YES));
            document.add(new FloatField("written_score",Float.parseFloat(each.get("written_score")), Field.Store.YES));
            document.add(new FloatField("half_written_score",Float.parseFloat(each.get("half_written_score")), Field.Store.YES));
            document.add(new FloatField("Interview_score",Float.parseFloat(each.get("Interview_score")), Field.Store.YES));
            document.add(new FloatField("half_Interview_score",Float.parseFloat(each.get("half_Interview_score")), Field.Store.YES));
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
