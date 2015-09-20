package com.test.java.solr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;


public class Test {
	public static String url = "http://192.168.100.107:8888/solr/test";
	public static void main(String[] args) throws Exception {
		HttpSolrServer server = getServer(url);
		addIndex(server);	
//		queryIndex(server);
//		deleteIndex(server);
		
	}
	public static void deleteIndex(HttpSolrServer server) throws Exception{
		server.deleteByQuery("*:*");
		server.commit();
	}
	public static void addIndex(HttpSolrServer server)throws Exception{
		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		
//		SolrInputDocument doc1 = new SolrInputDocument();
//		doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
//		doc1.addField("comments", "JAVA操作solr的实现其实很简单，但是很多细节要注意，在实际的开发中，很多人喜欢自己封装这些基础的方法以一个全新的“面貌”出现，其实都是一回事，操作熟了自然就会想到将一些实现功能用到的方法重新封装，这也是编程进阶的表现。");
//		SolrInputDocument doc = new SolrInputDocument();
//		doc.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
//		doc.addField("comments", " SolrJ覆盖了solr的全部功能，下面将自己在实际开发中所使用的程序粘贴出来并适当加以解释，由于本人比较菜，代码书写不是那么的精练，还请见谅。");
//		for(int i=0;i<10;i++){
//			SolrInputDocument doc1 = new SolrInputDocument();
//			doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
//			doc1.addField("price", "100."+i);
//			doc1.addField("weight", "90."+i);
//			docs.add(doc1);
//		}
		
		List<Map<String, String>> datas = AddDatas.getDatas();
//		Map<String, String> each = datas.get(0);
		for(Map<String,String> each:datas){
			SolrInputDocument doc1 = new SolrInputDocument();
			doc1.addField("id", UUID.randomUUID().toString().replaceAll("-",""));
			doc1.addField("project_id", each.get("id"));
			doc1.addField("project_number",each.get("project_number"));
			doc1.addField("project_name",each.get("project_name"));
			doc1.addField("region",each.get("region"));
			doc1.addField("tender_names",each.get("tender_names"));
			doc1.addField("tender_ids",each.get("tender_ids"));
			doc1.addField("process_instance_id",each.get("process_instance_id"));
			doc1.addField("project_amount_rmb",each.get("project_amount_rmb"));
			docs.add(doc1);
		}
//		docs.add(doc);
		server.add(docs);
		server.optimize();
		server.commit();
	}
	
	public static void queryIndex(HttpSolrServer server) throws Exception{
		String q = "comments:JAVA";
		SolrQuery sq = new SolrQuery(q);
		sq.setParam("fl", "coments");  
		sq.setHighlightSimplePre("<font color=\"red\">");   
		sq.setHighlightSimplePost("</font>");
		QueryResponse result = server.query(sq);
		Map<String, Map<String, List<String>>> highlighting = result.getHighlighting();
		
		SolrDocumentList results = result.getResults();
		for(int i=0;i<results.size();i++){
			Map<String, List<String>> map = highlighting.get("id");
			SolrDocument solrDocument = results.get(i);
			String id = (String)solrDocument.getFieldValue("id");
			solrDocument.setField("name", highlighting.get(id).get("name"));
			System.out.println(solrDocument.getFieldValue("name"));
		}
	}
	public static HttpSolrServer getServer(String url){
		HttpSolrServer server = new HttpSolrServer(url);
		server.setConnectionTimeout(1000);
		server.setDefaultMaxConnectionsPerHost(100);
		server.setSoTimeout(5000);  // socket read timeout  
        server.setConnectionTimeout(5000);  
        server.setDefaultMaxConnectionsPerHost(100);  
        server.setMaxTotalConnections(100);  
        server.setFollowRedirects(false); 
        return server;
	}
}
