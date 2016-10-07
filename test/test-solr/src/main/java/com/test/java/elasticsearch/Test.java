package com.test.java.elasticsearch;


import com.alibaba.fastjson.JSONObject;
import com.test.java.elasticsearch.content.News;
import com.test.java.elasticsearch.content.ParseHtml;
import com.test.java.elasticsearch.handlees.EsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micheal on 2016/7/24.
 */

public class Test {

    public static void main(String[] args) {
        List<News> list = new ArrayList<News>();
        for (int i = 544670; i <= 549670; i++) {
            try {
                ParseHtml html = new ParseHtml();
                News news = html.getNewsFromInet("https://news.cnblogs.com/n/" + i + "/");
                if (news.checkNews(news)) {
                    list.add(news);
                    System.out.println(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            EsService esService = new EsService();
            esService.bulkInsert(list);

        }
}
