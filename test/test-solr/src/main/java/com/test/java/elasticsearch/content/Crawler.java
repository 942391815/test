package com.test.java.elasticsearch.content;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Micheal on 2016/9/16.
 */
public class Crawler {
    public String getHtmlContent(String path) {
        StringBuffer sb = new StringBuffer();
        try {
            System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            URL url = new URL(path);
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
