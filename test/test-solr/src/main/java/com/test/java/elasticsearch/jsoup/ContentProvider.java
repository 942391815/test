package com.test.java.elasticsearch.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * Created by Micheal on 2016/9/16.
 */
public class ContentProvider {
    public static void getNewsFromInet() throws Exception {
        String ss = getHtmlContent();
        Document parse = Jsoup.parse(ss);
        Elements titleElements = parse.getElementsByAttributeValue("id", "news_title");
        Elements infoElements = parse.getElementsByAttributeValue("id", "news_info");
        Elements bodyElements = parse.getElementsByAttributeValue("id", "news_body");

        Iterator<Element> titleIterator = titleElements.iterator();
        while (titleIterator.hasNext()) {
            System.out.println(titleIterator.next().text());
        }
        Iterator<Element> infoIterator = infoElements.iterator();
        while (infoIterator.hasNext()) {
            Element element = infoIterator.next();
            System.out.println(element.getElementsByClass("time").text().split(" ")[1]);
            System.out.println(element.getElementsByClass("news_poster").text().split(" ")[1]);
        }
//        Iterator<Element> bodyIterator = bodyElements.iterator();
//        Element elements = bodyIterator.next();
//        Iterator<Element> iterator = elements.getAllElements().iterator();
//        while (iterator.hasNext()) {
//            String section = iterator.next().text().replace("p>", "\n");
//            if(section.length()>0){
//                System.out.println(section);
//            }
//        }
    }

    public static void main(String[] args) throws Exception {
        getNewsFromInet();
    }

    public static String getHtmlContent() {
        StringBuffer sb = new StringBuffer();
        try {
            System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            URL url = new URL("https://news.cnblogs.com/n/553589/");
            URLConnection connection = url.openConnection();
            InputStream ins = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            while (br.read() != -1) {
                sb.append(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
