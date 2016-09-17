package com.test.java.elasticsearch;


import com.test.java.elasticsearch.content.News;
import com.test.java.elasticsearch.content.ParseHtml;
import net.sf.json.JSONObject;

/**
 * Created by Micheal on 2016/7/24.
 */

public class Test {

    public static void main(String[] args) {
        for(int i=550483;i<553598;i++){
            try {
                ParseHtml html = new ParseHtml();
                News news = html.getNewsFromInet("https://news.cnblogs.com/n/"+i+"/");
                System.out.println(JSONObject.fromObject(news).toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
