package com.test.java.es;

import net.sf.json.JSONObject;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by qiaogu on 2016/12/16.
 */
public class InsertExam {
    public static void main(String[] args) throws Exception {
//        FileInputStream fis = new FileInputStream(new File("D:\\20160807172927448.xls"));
//        List<Map<String, String>> list = TestPoi.analysisExcel(fis);
//        insertExamBulk(list);
        insertTest();
    }

    private static void insertTest() throws ParseException {
        Person person = new Person();
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(15);
        person.setName("张三");
        person.setAddressId(list);
        person.setAge(28 + "");
        TransportClient client = EsUtils.localClient();
        IndexResponse indexResponse = client.prepareIndex("test_array",
                "test_array")
                .setSource(JSONObject.fromObject(person).toString()).execute().actionGet();
    }

    private static void insertExam(Map<String, String> map) throws ParseException {
        TransportClient client = EsUtils.localClient();
        IndexResponse indexResponse = client.prepareIndex("exam",
                "exam")
                .setSource(JSONObject.fromObject(map).toString()).execute().actionGet();
    }

    private static void insertExamBulk(List<Map<String, String>> list) throws ParseException {
        TransportClient client = EsUtils.localClient();
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for (Map<String, String> each : list) {
            IndexRequestBuilder indexRequestBuilder = client.prepareIndex("exam", "exam").setSource(JSONObject.fromObject(each).toString());
            bulkRequestBuilder.add(indexRequestBuilder);
        }
        BulkResponse bulkItemResponses = bulkRequestBuilder.execute().actionGet();
        if (bulkItemResponses.hasFailures()) {
            System.out.println(bulkItemResponses.buildFailureMessage());
        }
    }
}
