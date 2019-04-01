//package com.test.java.solr;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//
//
//public class Test {
//	public static String url = "http://192.168.100.107:8888/solr/test";
//	public static void main(String[] args) throws Exception {
//		HttpSolrServer server = getServer(url);
//		addIndex(server);
////		queryIndex(server);
////		deleteIndex(server);
//
//	}
//	public static void deleteIndex(HttpSolrServer server) throws Exception{
//		server.deleteByQuery("*:*");
//		server.commit();
//	}
//	public static void addIndex(HttpSolrServer server)throws Exception{
//		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
//
////		SolrInputDocument doc1 = new SolrInputDocument();
////		doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
////		doc1.addField("comments", "JAVA����solr��ʵ����ʵ�ܼ򵥣����Ǻܶ�ϸ��Ҫע�⣬��ʵ�ʵĿ����У��ܶ���ϲ���Լ���װ��Щ�����ķ�����һ��ȫ�µġ���ò�����֣���ʵ����һ���£�����������Ȼ�ͻ��뵽��һЩʵ�ֹ����õ��ķ������·�װ����Ҳ�Ǳ�̽��׵ı��֡�");
////		SolrInputDocument doc = new SolrInputDocument();
////		doc.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
////		doc.addField("comments", " SolrJ������solr��ȫ�����ܣ����潫�Լ���ʵ�ʿ�������ʹ�õĳ���ճ���������ʵ����Խ��ͣ����ڱ��˱Ƚϲˣ�������д������ô�ľ�����������¡�");
////		for(int i=0;i<10;i++){
////			SolrInputDocument doc1 = new SolrInputDocument();
////			doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
////			doc1.addField("price", "100."+i);
////			doc1.addField("weight", "90."+i);
////			docs.add(doc1);
////		}
//
//		List<Map<String, String>> datas = AddDatas.getDatas();
////		Map<String, String> each = datas.get(0);
//		for(Map<String,String> each:datas){
//			SolrInputDocument doc1 = new SolrInputDocument();
//			doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
//			doc1.addField("project_id", each.get("id"));
//			doc1.addField("project_number",each.get("project_number"));
//			doc1.addField("project_name",each.get("project_name"));
//			doc1.addField("region",each.get("region"));
//			doc1.addField("tender_names",each.get("tender_names"));
//			doc1.addField("tender_ids",each.get("tender_ids"));
//			doc1.addField("process_instance_id",each.get("process_instance_id"));
//			doc1.addField("project_amount_rmb",each.get("project_amount_rmb"));
//			docs.add(doc1);
//		}
////		docs.add(doc);
//		server.add(docs);
//		server.optimize();
//		server.commit();
//	}
//
//	public static void queryIndex(HttpSolrServer server) throws Exception{
//		String q = "comments:JAVA";
//		SolrQuery sq = new SolrQuery(q);
//		sq.setParam("fl", "coments");
//		sq.setHighlightSimplePre("<font color=\"red\">");
//		sq.setHighlightSimplePost("</font>");
//		QueryResponse result = server.query(sq);
//		Map<String, Map<String, List<String>>> highlighting = result.getHighlighting();
//
//		SolrDocumentList results = result.getResults();
//		for(int i=0;i<results.size();i++){
//			Map<String, List<String>> map = highlighting.get("id");
//			SolrDocument solrDocument = results.get(i);
//			String id = (String)solrDocument.getFieldValue("id");
//			solrDocument.setField("name", highlighting.get(id).get("name"));
//			System.out.println(solrDocument.getFieldValue("name"));
//		}
//	}
//	public static HttpSolrServer getServer(String url){
//		HttpSolrServer server = new HttpSolrServer(url);
//		server.setConnectionTimeout(1000);
//		server.setDefaultMaxConnectionsPerHost(100);
//		server.setSoTimeout(5000);  // socket read timeout
//        server.setConnectionTimeout(5000);
//        server.setDefaultMaxConnectionsPerHost(100);
//        server.setMaxTotalConnections(100);
//        server.setFollowRedirects(false);
//        return server;
//	}
//}
