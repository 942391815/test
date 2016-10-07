package com.test.java.elasticsearch.content;

import com.test.java.util.date.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.Iterator;

/**
 * Created by Micheal on 2016/9/16.
 */
public class ParseHtml {
    private Crawler crawler = new Crawler();

    public News getNewsFromInet(String htmlPath) {
        News news = new News();
        try{
        String ss = crawler.getHtmlContent(htmlPath);
        Document parse = Jsoup.parse(ss);
        StringBuffer content = new StringBuffer();
        Elements titleElements = parse.getElementsByAttributeValue("id", "news_title");
        Elements infoElements = parse.getElementsByAttributeValue("id", "news_info");
        Elements bodyElements = parse.getElementsByAttributeValue("id", "news_body");

            Iterator<Element> titleIterator = titleElements.iterator();
            while (titleIterator.hasNext()) {
                news.setTitle(titleIterator.next().text());
            }
            Iterator<Element> infoIterator = infoElements.iterator();
            while (infoIterator.hasNext()) {
                Element element = infoIterator.next();
                news.setCreator(element.getElementsByClass("news_poster").text().split(" ")[1]);
                Date createDate = DateUtil.stringConvertDate(element.getElementsByClass("time").text().split(" ")[1] + " " + element.getElementsByClass("time").text().split(" ")[2]);
                if (createDate != null) {
                    news.setCreateTime(createDate.getTime());
                }
            }
            Iterator<Element> bodyIterator = bodyElements.iterator();
            Element elements = bodyIterator.next();
            Iterator<Element> iterator = elements.getAllElements().iterator();
            while (iterator.hasNext()) {
                /**
                 * TODO <p> 标签未能处理掉。
                 */
                String section = iterator.next().text().replace("p>", "\n");
                if (section.length() > 0) {
                    content.append(section);
                }
            }
            news.setContent(content.toString());
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return news;
    }
}
