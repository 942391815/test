package com.test.java.analyzer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by qiaogu on 2016/12/27.
 */
public class Test {
    public static void main(String[] args) {
        StandardAnalyzer analyzer = new StandardAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream("myfield", new StringReader("some test goes here"));
        OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);

        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()){
                System.out.println(tokenStream.reflectAsString(true));
                System.out.println("start offset "+offsetAttribute.startOffset()+" end offset "+offsetAttribute.endOffset());
            }
            tokenStream.end();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                tokenStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
