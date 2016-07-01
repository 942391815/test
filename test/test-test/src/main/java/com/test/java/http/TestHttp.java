//package com.test.java.http;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//
//public class TestHttp {
//	public static void main(String[] args) throws Exception{
//		test();
////		loginIn();
//	    }  
//	public static void test() throws Exception{
//		HttpClient httpclient = new DefaultHttpClient();  
//        // 根据获得的Cookie值，设置头信息，然后发送请求，获得内容  
//        HttpPost httpget = new HttpPost("http://nbl.ebnew.com/approval/json/approval/userApprove/list");  
//        httpget.setHeader("Cookie", "JSESSIONID=B64A81108C47F19EE4E460BFDDED0613");
//        httpget.setHeader("Referer", "http://nbl.ebnew.com/portal/system_management/bpm_management/myapproval.html");
//        httpget.setHeader("X-Requested-With", "");
//        HttpResponse response = httpclient.execute(httpget);
//        //打印返回的结果  
//        HttpEntity entity = response.getEntity();  
//          
//        StringBuilder result = new StringBuilder();  
//        if (entity != null) {  
//            InputStream instream = entity.getContent();  
//            BufferedReader br = new BufferedReader(new InputStreamReader(instream));  
//            String temp = "";  
//            while ((temp = br.readLine()) != null) {  
//                String str = new String(temp.getBytes(), "utf-8");  
//                result.append(str);  
//            }  
//        }  
//        System.out.println(result);  
//		}
//	public static void loginIn() throws Exception{
//		HttpClient httpclient = new DefaultHttpClient();  
//        
//        //设置登录参数  
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
//        formparams.add(new BasicNameValuePair("username", "dyj001"));  
//        formparams.add(new BasicNameValuePair("password", "qaz123"));  
//        UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams, "UTF-8");  
//          
//        //新建Http  post请求  
//        HttpPost httppost = new HttpPost("https://cas.ebnew.com/cas/login");  
//        httppost.setEntity(entity1);  
//  
//        //处理请求，得到响应  
//        HttpResponse response = httpclient.execute(httppost);  
//      
//        String set_cookie = response.getFirstHeader("Set-Cookie").getValue();  
//          
//        //打印Cookie值  
//        System.out.println(set_cookie.substring(0,set_cookie.indexOf(";")));  
//          
//        //打印返回的结果  
//        HttpEntity entity = response.getEntity();  
//          
//        StringBuilder result = new StringBuilder();  
//        if (entity != null) {  
//            InputStream instream = entity.getContent();  
//            BufferedReader br = new BufferedReader(new InputStreamReader(instream));  
//            String temp = "";  
//            while ((temp = br.readLine()) != null) {  
//                String str = new String(temp.getBytes(), "utf-8");  
//                result.append(str);  
//            }  
//        }  
//        System.out.println(result); 
//	}
//	}