//package com.test.java.elasticsearch.index;
//
//import com.test.java.elasticsearch.ClientUtils;
//import net.sf.json.JSONObject;
//import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.Requests;
//import org.elasticsearch.common.xcontent.XContentBuilder;
//import org.elasticsearch.common.xcontent.XContentFactory;
//
///**
// * Created by Micheal on 2016/9/17.
// */
//public class IndexHandler {
//    public static void createMapping() throws Exception {
//        XContentBuilder builder = XContentFactory.jsonBuilder()
//                .startObject()
//                .startObject("type1")
//                .startObject("properties")
//                .startObject("analyzed").field("type", "string").field("index", "analyzed").field("searchAnalyzer", "ik").endObject()
//                .startObject("notanalyzed").field("type", "string").field("index", "not_analyzed").endObject()
//                .endObject()
//                .endObject()
//                .endObject();
////
////                .startObject("id").field("type", "integer").field("store", "yes").endObject()
////                .startObject("content").field("type", "string").field("store", "yes").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
////                .startObject("edate").field("type", "date").field("store", "yes").field("indexAnalyzer", "ik").field("searchAnalyzer", "ik").endObject()
////                .endObject();
//        Client client = ClientUtils.getClient();
//        IndexResponse indexResponse = client.prepareIndex("twitter", "twitter").setSource(builder).get();
//        System.out.println(JSONObject.fromObject(indexResponse).toString());
//    }
//
//    public static void main(String[] args) throws Exception {
//        createMapping();
//    }
//}
